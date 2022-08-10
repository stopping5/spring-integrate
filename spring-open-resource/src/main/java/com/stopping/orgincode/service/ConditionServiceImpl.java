package com.stopping.orgincode.service;

import com.stopping.orgincode.pojo.MyConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname: ConditionServiceImpl
 * @Date: 2022/6/1 3:42 下午
 * @author: stopping
 */
@Service
public class ConditionServiceImpl {
    @Resource
    private MyConfig myConfig;

    public void get(){
        myConfig.getName();
    }
}
