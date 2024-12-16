package com.kafka.springmybatis01.transcation;

import com.kafka.springmybatis01.service.transcation.RequiredNewService;
import com.kafka.springmybatis01.service.transcation.RequiredService;
import com.kafka.springmybatis01.service.transcation.SupportService;
import com.kafka.springmybatis01.service.transcation.TransactionalDemo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionalDemoTest {

    @Resource
    private RequiredNewService requiredNewService;

    @Resource
    private SupportService supportService;

    @Resource
    private RequiredService requiredService;

    @Test
    public void requiredToRequiredNew(){
        requiredNewService.requiredToRequiredNewOut();
    }

    /**
     * 事务传播 required->Support，外部事务发生异常内部事务是属于同一个事务则数据全部回滚
     */
    @Test
    public void requiredToSupport(){
//        supportService.requiredToSupport();

        supportService.notTransactionalToSupport();
    }

    @Test
    public void requiredToTransactional(){
        requiredService.requiredInNotTransaction();
    }
}