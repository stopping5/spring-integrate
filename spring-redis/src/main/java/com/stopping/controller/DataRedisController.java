package com.stopping.controller;

import com.stopping.service.IRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 数据缓存接口
 * @Classname: DataRedisController
 * @Date: 2022/5/17 11:23 上午
 * @author: stopping
 */
@RestController
@RequestMapping("/data")
public class DataRedisController {
    @Resource
    private IRedisService iRedisService;

    @GetMapping("/get")
    public String get(@RequestParam("key")String key){
        return iRedisService.getString(key);
    }
}
