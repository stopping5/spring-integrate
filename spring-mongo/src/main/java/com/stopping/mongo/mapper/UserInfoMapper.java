package com.stopping.mongo.mapper;

import com.stopping.mongo.pojo.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserInfoMapper extends MongoRepository<UserInfo,String> {
    /**
     * 查询UserInfo通过手机号
     * @param phone
     * @return
     */
    List<UserInfo> findAllByPhone(String phone);

    /**
     * 通过手机号删除
     * @param phone
     */
    void deleteUserInfoByPhone(String phone);


}
