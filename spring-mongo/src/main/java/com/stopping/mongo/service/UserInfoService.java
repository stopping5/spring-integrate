package com.stopping.mongo.service;

import com.stopping.mongo.pojo.UserInfo;
import java.util.Arrays;
import java.util.List;
/**
 * UserInfo业务代码
 */
public interface UserInfoService {
    /**
     * 保存UserInfo
     * @return
     */
    boolean saveUserInfo();

    /**
     * 不通过手机号查询UserInfo
     * @param phone
     * @return
     */
    List<UserInfo> findUserInfoByPhone(String phone);

    /**
     * 删除UserInfo
     * @param phone
     */
    void deleteUserInfo(String phone);
}
