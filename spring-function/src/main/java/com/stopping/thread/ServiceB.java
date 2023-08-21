package com.stopping.thread;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author stopping
 * @Descroption ServiceB
 * @Date 2023/8/12 17:01
 */
@Service
public class ServiceB {

    private final ThreadPoolExecutor SERVICE_B_POOL = new ThreadPoolExecutor(4,20,10,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadFactoryBuilder().setNamePrefix("service-b").setDaemon(true).build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public Boolean sendBService(List<Integer> number){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (Integer num : number){
            SERVICE_B_POOL.submit(()->{
                executor(num);
            });
        }
        stopWatch.stop();
        System.out.println("--------------------- 获取线程"+Thread.currentThread().getName()+"异步处理结束，耗时 = " + stopWatch.getTotalTimeMillis());
        return true;
    }

    private void executor(Integer num){
        System.out.println("线程"+Thread.currentThread().getName()+"执行业务 num  =" + num);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
