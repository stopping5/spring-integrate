package com.stopping;

import com.stopping.javaspi.service.Developer;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<Developer> developers = ServiceLoader.load(Developer.class);
        developers.forEach(Developer::sayHello);
    }
}