package com.kafka.springmybatis01.service.impl;

import com.kafka.springmybatis01.dao.UserMapper;
import com.kafka.springmybatis01.entity.User;
import com.kafka.springmybatis01.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user,boolean flag) {

        userMapper.insert(user);

        if (flag) {
            throw new RuntimeException("has exception");
        }
    }
}
