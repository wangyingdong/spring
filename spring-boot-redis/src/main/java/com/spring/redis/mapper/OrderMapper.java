package com.spring.redis.mapper;

import com.spring.redis.common.mapper.BasicMapper;
import com.spring.redis.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BasicMapper<Order> {


}

