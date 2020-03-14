package com.f139.rocketmq.listener;


import com.alibaba.fastjson.JSON;
import com.f139.rocketmq.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "topic", consumerGroup = "topic-group")
@Slf4j
public class TopicListener implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order order) {
        log.info("TopicListener received message, body:{} ", JSON.toJSON(order));
    }


}
