package com.stopping.rocketmq.client;

import com.stopping.rocketmq.pojo.Common;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * RocketMQ消费者
 * @Classname: ClientCustomerDemo
 * @Date: 2022/11/15 5:30 下午
 * @author: stopping
 */

public class ClientCustomerDemo {
    public static void main(String[] args) throws MQClientException {
        defaultMQPushConsumer();
    }

    /**
     * 默认监听消息
     * @throws MQClientException
     */
    public static void defaultMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Common.CUSTOMER_GROUP_NAME);
        consumer.setNamesrvAddr(Common.ADDR);
        //订阅关系（topic 和 标签过滤）
        consumer.subscribe(Common.SYN_MSG_TOPIC,"log");
        //消息监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), new String(list.get(0).getBody()));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("接收MQ消息完毕");
    }
}
