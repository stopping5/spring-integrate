package com.kafka.springmybatis01.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kafka.springmybatis01.entity.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
