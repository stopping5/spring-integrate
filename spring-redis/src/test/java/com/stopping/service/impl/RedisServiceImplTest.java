package com.stopping.service.impl;

import com.stopping.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Classname: RedisServiceImplTest
 * @Date: 2022/5/16 2:22 下午
 * @author: stopping
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisServiceImplTest {
    @Autowired
    RedisServiceImpl redisServiceImpl;

    @Test
    public void setValue(){
        redisServiceImpl.setString("hello","hello");
        log.info(redisServiceImpl.getString("hello"));
    }
}
