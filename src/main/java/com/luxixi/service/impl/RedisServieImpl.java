package com.luxixi.service.impl;

import com.luxixi.redis.RedisUtil;
import com.luxixi.service.RedisService;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisServieImpl implements RedisService {

    private final RedisUtil redisUtil;

    private final WxMpService wxMpService;

    @Override
    public boolean add(String key, String value) {
        return redisUtil.set(key,value);
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
