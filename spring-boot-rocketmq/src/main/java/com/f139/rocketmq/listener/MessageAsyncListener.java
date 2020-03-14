package com.f139.rocketmq.listener;


import com.alibaba.fastjson.JSON;
import com.f139.rocketmq.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RocketMQMessageListener(topic = "message", consumerGroup = "message-group-async",selectorExpression = "async")
public class MessageAsyncListener implements RocketMQListener<Order>{


    @Override
    public void onMessage(Order message) {
        log.info("MessageAsyncListener received message, body:{} ", JSON.toJSON(message));
    }



}
