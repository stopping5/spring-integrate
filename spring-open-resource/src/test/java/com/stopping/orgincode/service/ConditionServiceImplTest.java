package com.stopping.orgincode.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Classname: ConditionServiceImplTest
 * @Date: 2022/6/1 3:48 下午
 * @author: stopping
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ConditionServiceImplTest {
    @Resource
    private ConditionServiceImpl conditionServiceImpl;

    @Test
    private void test(){
        System.out.println("11");
        System.out.println("ok");
    }
}