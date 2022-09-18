package com.stopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname: SpelApplication
 * @Description: TODO
 * @Date: 2022/9/15 11:36 上午
 * @author: stopping
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpelApplication.class);
    }
}
