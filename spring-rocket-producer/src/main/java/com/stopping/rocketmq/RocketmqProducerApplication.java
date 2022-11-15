package com.stopping.rocketmq;

import com.stopping.rocketmq.spring.ProducerExample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class RocketmqProducerApplication implements CommandLineRunner {
    @Resource
    private ProducerExample producerExample;

    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producerExample.sendAsyncMsg();
    }
}
