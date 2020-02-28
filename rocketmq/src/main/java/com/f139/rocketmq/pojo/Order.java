package com.f139.rocketmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class Order implements Serializable {

    private String orderId;
    private BigDecimal paidMoney;
}



