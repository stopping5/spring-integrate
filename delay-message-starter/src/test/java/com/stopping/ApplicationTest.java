package com.stopping;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO
 * @Author stopping
 * @Date 2023/9/14 2:44 PM
 * @PackageName:com.stopping
 * @ClassName: ApplicationTest
 */
@SpringBootTest
class ApplicationTest {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void zSetTest(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        LocalDateTime plus = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
        zSetOperations.add("delay:hello","hello1", TimeUnit.MINUTES.toMillis(1));

        Set set = zSetOperations.rangeByScore("delay:hello", 1, 70000);
        set.stream().forEach(System.out::println);
    }
}