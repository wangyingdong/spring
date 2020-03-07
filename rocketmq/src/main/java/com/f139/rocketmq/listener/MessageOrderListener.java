package com.f139.rocketmq.listener;

import com.alibaba.fastjson.JSON;
import com.f139.rocketmq.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j

@RocketMQMessageListener(topic = "message", consumerGroup = "message-order",selectorExpression = "order")
public class MessageOrderListener implements RocketMQListener<List> {


    @Override
    public void onMessage(List message) {
        log.info("MessageOrderListener received message, body:{} ",JSON.toJSONString(message));

    }
}
