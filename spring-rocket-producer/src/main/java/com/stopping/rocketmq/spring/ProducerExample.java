package com.stopping.rocketmq.spring;

import com.stopping.rocketmq.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname: ProducerExample
 * @Date: 2022/11/9 11:36 上午
 * @author: stopping
 */
@Service
@Slf4j
public class ProducerExample {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    private static final String TOPIC_NAME = "hello-topic";

    private static final String USER_TAG = "user";

    public void sendAsyncMsg(){
        UserInfo userInfo = new UserInfo("stopping",19);
        Message message = MessageBuilder.withPayload(userInfo).setHeader(RocketMQHeaders.TAGS,USER_TAG).setHeader(RocketMQHeaders.TOPIC,TOPIC_NAME).build();
        //rocketMQTemplate.convertAndSend(TOPIC_NAME,message);

        //rocketMQTemplate.convertAndSend(TOPIC_NAME + ":user", "I'm from tag0");

        rocketMQTemplate.asyncSend(TOPIC_NAME + ":user", userInfo, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("接收消息处理成功回调:{}",sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("接收消息处理失败回调:{}",throwable);
            }
        },3000);
    }
}
