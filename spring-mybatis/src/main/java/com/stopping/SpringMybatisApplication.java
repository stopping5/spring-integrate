package com.stopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname: SpringMybatisApplication
 * @Description: TODO
 * @Date: 2023/4/8 10:52 上午
 * @author: stopping
 */
@SpringBootApplication
@MapperScan(basePackages = "com.stopping.dao")
public class SpringMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisApplication.class,args);
    }
}
