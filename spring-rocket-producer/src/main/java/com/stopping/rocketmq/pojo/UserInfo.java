package com.stopping.rocketmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname: UserInfo
 * @Date: 2022/11/9 2:48 下午
 * @author: stopping
 */
@Data
@AllArgsConstructor
public class UserInfo {

    private String username;

    private Integer age;
}
