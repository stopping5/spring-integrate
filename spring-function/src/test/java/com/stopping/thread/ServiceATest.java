package com.stopping.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceATest {

    @Resource
    private ServiceA serviceA;

    @Test
    public void test(){
        serviceA.asyncRun();
    }
}