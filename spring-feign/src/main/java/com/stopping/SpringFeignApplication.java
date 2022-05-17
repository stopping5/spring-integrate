package com.stopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Springboot 启动类
 */
@SpringBootApplication
@EnableFeignClients
public class SpringFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFeignApplication.class,args);
    }
}
