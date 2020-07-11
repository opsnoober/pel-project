package com.luxixi.controller;

import com.luxixi.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController extends BaseController {

    @Resource
    private RedisService redisService;

    @RequestMapping("/add")
    @GetMapping
    public boolean add(String key , String value){
        return redisService.add(key,value);
    }

    @RequestMapping("/{key}")
    @GetMapping
    public String getByKey(@PathVariable String key){
        return redisService.getByKey(key);
    }
}
