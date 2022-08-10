package com.stopping.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Classname: SpringMongoApplication
 * @Date: 2022/8/10 10:30 上午
 * @author: stopping
 */
@SpringBootApplication
@EnableMongoAuditing
public class SpringMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class);
    }
}
