package com.stopping.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

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
    }
}
