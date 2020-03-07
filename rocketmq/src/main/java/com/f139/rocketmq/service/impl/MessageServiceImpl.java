package com.f139.rocketmq.service.impl;

import com.f139.rocketmq.pojo.Order;
import com.f139.rocketmq.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class MessageServiceImpl implements IMessageService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage() {
        //同步消息
        SendResult result = rocketMQTemplate.syncSend("topic", Order.builder().orderId("T001").paidMoney(new BigDecimal(100)).build());
        log.info(result.toString());
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.sendOneWay("message:sync", Order.builder().orderId("T002").paidMoney(new BigDecimal(100)).build());
        }
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.builder().orderId("T003").desc("创建").paidMoney(new BigDecimal(100)).build());
        orderList.add(Order.builder().orderId("T004").desc("创建").paidMoney(new BigDecimal(100)).build());
        orderList.add(Order.builder().orderId("T003").desc("付款").paidMoney(new BigDecimal(100)).build());
        orderList.add(Order.builder().orderId("T004").desc("付款").paidMoney(new BigDecimal(100)).build());
        orderList.add(Order.builder().orderId("T004").desc("完成").paidMoney(new BigDecimal(100)).build());
        orderList.add(Order.builder().orderId("T003").desc("完成").paidMoney(new BigDecimal(100)).build());

        rocketMQTemplate.asyncSendOrderly("message:order", orderList, orderList.toString(), null);


        //异步消息
        rocketMQTemplate.asyncSend("message:async", Order.builder().orderId("T006").paidMoney(new BigDecimal(100)).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("send successful");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("send fail:{}", throwable.getMessage());
            }
        }, 500L);
    }


}
