package com.luxixi.controller;

import com.luxixi.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
@Api(tags = "redis通用接口")
public class RedisController extends BaseController {

    @Resource
    private RedisService redisService;

    @ApiOperation(value = "添加键值对")
    @GetMapping("/add")
    public boolean add(String key , String value){
        return redisService.add(key,value);
    }

    @ApiOperation(value = "根据键获取值")
    @GetMapping("/{key}")
    public String getByKey(@PathVariable String key){
        return redisService.getByKey(key);
    }
}
