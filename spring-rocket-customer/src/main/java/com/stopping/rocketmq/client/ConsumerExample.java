package com.stopping.rocketmq.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Classname: ConsumerExample
 * @Date: 2022/11/9 2:51 下午
 * @author: stopping
 */
@Service
@RocketMQMessageListener(topic = "hello-topic",consumerGroup = "hello_consumer_1",selectorType = SelectorType.TAG,selectorExpression = "user")
@Slf4j
public class ConsumerExample implements RocketMQListener<String> {

    @Override
    public void onMessage(String message){
        log.info("监听hello-topic消息:{}",message);
    }
}
