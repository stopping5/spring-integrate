package com.stopping.rocketmq.client;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @Classname: ProducerSendMsgDemo
 * @Description: 生产者发送消息
 * @Date: 2022/11/15 3:30 下午
 * @author: stopping
 */
public class ProducerSendMsgDemo {
    public static final String ADDR = "120.24.242.44:9876";

    public static final String TOPIC = "SynMsgTopic";

    public static void main(String[] args) throws Exception {
        sendSyncMsg("hello-async");
    }

    /**
     * 同步消息
     * 消息发送到服务端之后实施返回提交结果，send有返回值
     * 敏感信息实时回调
     * @param msg
     * @throws MQClientException
     * @throws RemotingException
     * @throws InterruptedException
     * @throws MQBrokerException
     */
    public static void sendSyncMsg(String msg) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //生产者
        DefaultMQProducer producer = new DefaultMQProducer("syn_producer_send_msg");
        //设置服务地址
        producer.setNamesrvAddr(ADDR);
        //启动生产者
        producer.start();

        for (int i = 0; i < 10; i++) {
            String sendMsg = msg+i;
            System.out.println("发送消息:"+sendMsg);
            //发送消息 指定TOPIC、TAG、消息载体
            Message message = new Message(TOPIC,"tagA",sendMsg.getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n",sendResult);
        }

        producer.shutdown();
    }

    /**
     * 异步消息 通知结果通过SendCallback回调，send没有返回值
     * 即发送端不能容忍长时间地等待Broker的响应。
     * @param msg
     * @throws Exception
     */
    public static void asyncMsg(String msg) throws Exception {
        //生产者
        DefaultMQProducer producer = new DefaultMQProducer("async_producer_send_msg");
        //设置服务地址
        producer.setNamesrvAddr(ADDR);
        //启动生产者
        producer.start();

        for (int i = 0; i < 10; i++) {
            String sendMsg = msg+i;
            System.out.println("发送消息:"+sendMsg);
            //发送消息 指定TOPIC、TAG、消息载体
            Message message = new Message(TOPIC,"tagA",sendMsg.getBytes(StandardCharsets.UTF_8));
            //异步消息回调
            SendCallback sendCallback =  new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("消息发送成功%n%s",sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送异常");
                }
            };
            producer.send(message,sendCallback);
        }
        producer.shutdown();
    }

    /**
     * 当方向发送消息，无返回值
     * 使用于不关心结果的数据，例如日志
     * @param msg
     * @throws Exception
     */
    public static void sendOnWayMsg(String msg) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("log_group");
        producer.setNamesrvAddr(ADDR);
        producer.start();

        for (int i = 0; i < 10; i++) {
            Message message = new Message(TOPIC,"log",msg.getBytes(StandardCharsets.UTF_8));
            producer.sendOneway(message);
        }

    }
}
