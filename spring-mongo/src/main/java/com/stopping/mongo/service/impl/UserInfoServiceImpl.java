package com.stopping.mongo.service.impl;

import com.stopping.mongo.mapper.UserInfoMapper;
import com.stopping.mongo.pojo.UserInfo;
import com.stopping.mongo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean saveUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("stopping");
        userInfo.setPhone("13143359896");
        userInfo.setSex(1);
        userInfo.setEmail("1064076070");

        UserInfo.Address address = new UserInfo.Address();
        address.setLatitude("111.1");
        address.setLongitude("123.2");
        address.setName("深圳");
        userInfo.setAddress(address);
        userInfoMapper.save(userInfo);
        return true;
    }

    @Override
    public List<UserInfo> findUserInfoByPhone(String phone) {
        return userInfoMapper.findAllByPhone(phone);
    }

    @Override
    public void deleteUserInfo(String phone) {
        userInfoMapper.deleteUserInfoByPhone(phone);
    }
}
