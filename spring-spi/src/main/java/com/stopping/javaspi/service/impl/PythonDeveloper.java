package com.stopping.javaspi.service.impl;

import com.stopping.javaspi.service.Developer;

/**
 * PYTHON hello接口
 */
public class PythonDeveloper implements Developer {
    @Override
    public void sayHello() {
        System.out.println("hello,phthon");
    }
}
