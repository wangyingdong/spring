package com.f139.rocketmq.listener;


import com.alibaba.fastjson.JSON;
import com.f139.rocketmq.pojo.Order;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "topic", consumerGroup = "topic-group")
public class TopicListener implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order order) {
        System.out.println(String.format("------- MessageExtConsumer received message, body:%s ", JSON.toJSON(order)));
    }


}
