package com.f139.rocketmq.service.impl;

import com.f139.rocketmq.pojo.Order;
import com.f139.rocketmq.service.IMessageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;


@Service
public class MessageServiceImpl implements IMessageService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage() {
        rocketMQTemplate.syncSend("topic", new Order("T_001", new BigDecimal("88.00")));
        rocketMQTemplate.syncSend("message:sync", new Order("T_002", new BigDecimal("99.00")));
        rocketMQTemplate.asyncSend("message:async", new Order("T_003", new BigDecimal("100.00")),null,500L);
    }


}
