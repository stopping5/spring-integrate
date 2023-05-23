package com.stopping.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisHashTest {

    @Resource
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void testHash(){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();

        String userId = "stopping";
        String text = "text";
        String card = "card";

        hash.put(userId,text,1);
        hash.put(userId,card,1);
        hash.increment(userId,text,1);
        Set<Object> keys = hash.keys(userId);
        keys.forEach(k->{
            System.out.println("获取redis keys:" + k.toString());
        });
        Map<Object, Object> entries = hash.entries(userId);
        entries.forEach((k,v)->{
            System.out.println("k="+k+","+"v="+v);

        });
        //通过HashMap保存，测试是否覆盖
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put(text,5);
        hashMap.put(card,5);
        hash.putAll(userId,hashMap);
        Map<Object, Object> entriesMap = hash.entries(userId);
        entriesMap.forEach((k,v)->{
            System.out.println("k="+k+","+"v="+v);

        });
        //对于UserId设置过期时间，测试是否全局生效,当KEY存在的时候才会生效
        redisTemplate.expire(userId,1, TimeUnit.DAYS);
    }

    @Test
    public void test(){
        String userId = "stopping";
        redisTemplate.expire(userId,2,TimeUnit.DAYS);
        redisTemplate.opsForHash().put(userId,"card",200);
    }
}
