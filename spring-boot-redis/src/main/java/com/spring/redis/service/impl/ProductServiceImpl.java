package com.spring.redis.service.impl;

import com.spring.redis.entity.Order;
import com.spring.redis.entity.Product;
import com.spring.redis.mapper.OrderMapper;
import com.spring.redis.mapper.ProductMapper;
import com.spring.redis.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements IProductService {


    @Resource
    public ProductMapper productMapper;

    @Resource
    public OrderMapper orderMapper;


    @Override
    public Product getProduct(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void reduceStock(Integer id) {
        orderMapper.insert(Order.builder().productId(id).datetime(LocalDateTime.now()).build());
        productMapper.reduceStock(id);
    }
}
