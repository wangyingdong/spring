package com.f139.rocketmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@Builder
public class Order implements Serializable {

    private String orderId;
    private String desc;
    private BigDecimal paidMoney;




}



