package com.stopping.service;

/**
 * @Classname: IRedisService
 * @Date: 2022/5/16 2:13 下午
 * @author: stopping
 */
public interface IRedisService {
    String getString(String key);

    void setString(String key,String value);
}
