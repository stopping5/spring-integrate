package com.stopping.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * redis服务调用
 * @Classname: RedisServiceFeign
 * @FeignClient value 服务名称 url 请求路径 path 上下文&前缀
 * 本feign请求最终地址http://localhost:8080/redis/data/get?key=hello
 * @Date: 2022/5/17 11:19 上午
 * @author: stopping
 */
@Component
@FeignClient(value = "redis-com.stopping.service",url = "localhost:8080",path = "/redis")
public interface RedisServiceFeign {
    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    @GetMapping("/data/get")
    String get(@RequestParam("key")String key);
    /**
     * 获取缓存数据鉴权接口
     * @param token
     * @param key
     * @return
     */
    @GetMapping("/data/get")
    String getAuth(@RequestParam("key")String key, @RequestHeader("token")String token);
    /**
     * 获取缓存数据鉴权接口
     * @param key
     * @return
     */
    @GetMapping("/data/get")
    String getAuth(@RequestParam("key")String key);
}
