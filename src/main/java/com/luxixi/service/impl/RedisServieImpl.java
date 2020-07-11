package com.luxixi.service.impl;

import com.luxixi.redis.RedisUtil;
import com.luxixi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServieImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean add(String key, String value) {
        return redisUtil.set(key,value);
    }

    @Override
    public String getByKey(String key) {
        return (String)redisUtil.get(key);
    }
}
