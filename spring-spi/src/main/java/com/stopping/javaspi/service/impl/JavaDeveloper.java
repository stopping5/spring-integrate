package com.stopping.javaspi.service.impl;

import com.stopping.javaspi.service.Developer;

/**
 * JAVA 接口实现
 */
public class JavaDeveloper implements Developer {
    @Override
    public void sayHello() {
        System.out.println("hello,java");
    }
}
