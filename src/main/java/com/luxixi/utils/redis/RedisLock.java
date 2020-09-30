package com.luxixi.utils.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = redisTemplate.opsForValue().setIfAbsent(lockKey, requestId, expireTime, TimeUnit.MINUTES);
            tryCount--;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                logger.error("线程被中断" + Thread.currentThread().getId(), e);
            }
        }
        return locked;

    }

    /**
     * 使用lua脚本解锁，不会解除别人锁
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean unlockLua(String lockKey, String requestId) {
        if (lockKey == null || requestId == null)
            return false;
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        //用于解锁的lua脚本位置
        redisScript.setLocation(new ClassPathResource("unlock.lua"));
        redisScript.setResultType(Long.class);
        //没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(lockKey), requestId);
        return result.equals(Long.valueOf(1));
    }
}
