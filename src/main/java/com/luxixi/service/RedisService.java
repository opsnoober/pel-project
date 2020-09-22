package com.luxixi.service;

import com.luxixi.common.result.Result;

public interface RedisService {

    Result add(String key, String value);

    String getByKey(String key);

    String getMpAccessToken();
}
