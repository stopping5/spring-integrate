package com.stopping.controller;

import com.stopping.feign.RedisServiceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 数据服务接口
 * @Classname: DataController
 * @Date: 2022/5/17 11:30 上午
 * @author: stopping
 */
@RestController
@RequestMapping("/data")
public class DataController {
    @Resource
    private RedisServiceFeign redisServiceFeign;

    @GetMapping("/get/{key}")
    public String get(@PathVariable("key")String key){
        return redisServiceFeign.get(key);
    }
}
