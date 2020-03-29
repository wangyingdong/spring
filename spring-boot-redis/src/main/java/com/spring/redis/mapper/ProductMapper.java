package com.spring.redis.mapper;

import com.spring.redis.common.mapper.BasicMapper;
import com.spring.redis.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BasicMapper<Product> {


    void reduceStock(Integer id);
}
