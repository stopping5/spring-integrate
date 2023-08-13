package com.stopping.thread;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stopping
 * @Descroption ServiceB
 * @Date 2023/8/12 17:01
 */
@Service
public class ServiceB {

    public Boolean sendBService(List<Integer> number){
        System.out.println("获取线程"+Thread.currentThread().getName()+"提交数据" + number);
        try {
            Thread.sleep(2000);
            System.out.println("模拟线程执行中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕");
        return true;
    }
}
