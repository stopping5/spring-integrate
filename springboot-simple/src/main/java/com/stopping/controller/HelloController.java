package com.stopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    @GetMapping("/say")
    public String sayHello(String hello){
        System.out.println("接收参数:"+hello);
        return "say" + hello;
    }

    @GetMapping("/exception")
    public String exception(int i){
        System.out.println("接收参数:"+ (2 / i));
        Integer result = i + 2;
        return "say" + i;
    }

    @PostMapping("/name")
    public Boolean save(String name){
        System.out.println("save:" + name);
        return true;
    }
}
