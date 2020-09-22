package com.luxixi.controller;

import com.luxixi.common.result.Result;
import com.luxixi.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
@Api(tags = "redis通用接口")
public class RedisController extends BaseController {

    @Resource
    private RedisService redisService;

    @ApiOperation(value = "添加键值对")
    @GetMapping("/add")
    public Result add(@RequestParam("key") String key , @RequestParam("value")String value){
        return redisService.add(key,value);
    }

    @ApiOperation(value = "根据键获取值")
    @GetMapping("/{key}")
    public String getByKey(@PathVariable String key){
        return redisService.getByKey(key);
    }

    @ApiOperation(value = "获取公众号的access_token")
    @GetMapping("/getMpAccessToken")
    public String getMpAccessToken(){
        return redisService.getMpAccessToken();
    }
}
