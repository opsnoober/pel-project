package com.luxixi.service.impl;

import com.luxixi.common.result.Result;
import com.luxixi.redis.RedisLock;
import com.luxixi.redis.RedisUtil;
import com.luxixi.service.RedisService;
import com.luxixi.utils.ResultUtil;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisServieImpl implements RedisService {

    private final RedisUtil redisUtil;

    private final WxMpService wxMpService;

    @Override
    public Result add(String key, String value) {
        boolean set = redisUtil.set(key, value);
        return ResultUtil.success(set);
    }

    @Override
    public String getByKey(String key) {
        return (String)redisUtil.get(key);
    }

    @Override
    public String getMpAccessToken() {
        try {
            return wxMpService.getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
