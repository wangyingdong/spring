package com.spring.mybatis.entity;

import lombok.Data;

@Data
public class Page {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private Boolean count = true;
}
