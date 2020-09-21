package com.luxixi.service;

public interface RedisService {

    boolean add(String key, String value);

    String getByKey(String key);

    String getMpAccessToken();
}
