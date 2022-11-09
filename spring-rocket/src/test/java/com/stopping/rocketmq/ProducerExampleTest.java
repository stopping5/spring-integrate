package com.stopping.rocketmq;

import com.stopping.rocketmq.pojo.UserInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Classname: ProducerExampleTest
 * @Date: 2022/11/9 1:52 下午
 * @author: stopping
 */
@SpringBootTest
public class ProducerExampleTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendMsg(){
        UserInfo userInfo = new UserInfo("stopping",19);
        rocketMQTemplate.convertAndSend("hello-topic",userInfo);
    }
}
