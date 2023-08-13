package com.stopping.thread;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 服务A
 * @author stopping
 * @Descroption ServiceA
 * @Date 2023/8/12 11:36
 */
@Service
@AllArgsConstructor
public class ServiceA {

    private ServiceB serviceB;

    private final ThreadPoolExecutor THREAD_POOL =
            new ThreadPoolExecutor(5,
                    8,
                    1000,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(100),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 生成1000条数据并且每一百条进行分组
     * @return 数据集合
     */
    public List<List<Integer>> get(){
        List<Integer> data = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }
        return CollUtil.split(data,100);
    }

    public void asyncRun(){
        System.out.println("异步逻辑开始执行");
        get().stream().forEach(s->{
            THREAD_POOL.submit(()->{
                serviceB.sendBService(s);
            });
        });
        System.out.println("异步逻辑执行完毕");
    }
}
