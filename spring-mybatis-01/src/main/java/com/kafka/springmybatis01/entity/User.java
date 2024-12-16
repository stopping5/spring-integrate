package com.kafka.springmybatis01.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
}
