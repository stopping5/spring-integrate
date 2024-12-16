package com.kafka.springmybatis01.service.impl;

import com.kafka.springmybatis01.entity.User;
import com.kafka.springmybatis01.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void insert() {

        User user = new User();
        user.setUsername("dd");
        user.setPassword("dd");

        userService.insert(user,false);
    }
}