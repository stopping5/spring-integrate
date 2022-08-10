package com.stopping.service.impl;

import com.stopping.service.IRedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 * Redis实现
 * @Classname: RedisServiceImpl
 * @Date: 2022/5/16 2:14 下午
 * @author: stopping
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String,String> redisTemplate1;

    @Override
    public String getString(String key) {
        return redisTemplate1.opsForValue().get(key);
    }

    @Override
    public void setString(String key, String value) {
        redisTemplate1.opsForValue().set(key,value);
    }
}
