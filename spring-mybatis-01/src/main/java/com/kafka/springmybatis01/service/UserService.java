package com.kafka.springmybatis01.service;

import com.kafka.springmybatis01.entity.User;

public interface UserService {
    void insert(User user,boolean flag);
}
