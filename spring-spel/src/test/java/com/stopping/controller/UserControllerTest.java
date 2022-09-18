package com.stopping.controller;

import com.stopping.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {
    @Resource
    private UserController userController;

    @Test
    public void test(){

        userController.getUser(new User("stopping",11));
    }
}