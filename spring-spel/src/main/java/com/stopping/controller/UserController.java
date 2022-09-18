package com.stopping.controller;

import com.stopping.annotation.ValueMap;
import com.stopping.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    @ValueMap("#user.username")
    public void getUser(@RequestBody User user){
        System.out.println("接收User："+user.toString());
    }
}
