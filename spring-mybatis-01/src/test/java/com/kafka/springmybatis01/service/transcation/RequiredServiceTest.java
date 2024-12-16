package com.kafka.springmybatis01.service.transcation;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequiredServiceTest {

    @Resource
    private RequiredService requiredService;

    @Test
    void required() {
        requiredService.required();
    }
}