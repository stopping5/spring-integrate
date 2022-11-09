package com.stopping.rocketmq;

import com.stopping.rocketmq.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Classname: ProducerExampleTest
 * @Date: 2022/11/9 1:52 下午
 * @author: stopping
 */
@SpringBootTest
@Slf4j
public class ProducerExampleTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    private static final String TOPIC_NAME = "hello-topic";

    private static final String USER_TAG = "user";

    @Test
    public void sendMsg(){
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
        });
    }
}
