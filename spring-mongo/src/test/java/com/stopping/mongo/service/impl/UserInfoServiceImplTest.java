package com.stopping.mongo.service.impl;

import com.stopping.mongo.pojo.UserInfo;
import com.stopping.mongo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class UserInfoServiceImplTest {
    @Resource
    private UserInfoService userInfoService;

    @Test
    void saveUserInfo() {
        userInfoService.saveUserInfo();
    }
    @Test
    void findUserInfo(){
        List<UserInfo> page = userInfoService.findUserInfoByPhone("13143359896");
        log.info("查询结果:{}",page);
    }

    @Test
    void delUserInfo(){
        userInfoService.deleteUserInfo("13143359896");
    }
}