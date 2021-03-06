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
@RocketMQMessageListener(topic = "message", consumerGroup = "message-group-sync",selectorExpression = "sync")
@Slf4j
public class MessageSyncListener implements RocketMQListener<Order>, RocketMQPushConsumerLifecycleListener {


    @Override
    public void onMessage(Order message) {
        log.info("MessageSyncListener received message, body:{} ", JSON.toJSON(message));
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
    }

}
