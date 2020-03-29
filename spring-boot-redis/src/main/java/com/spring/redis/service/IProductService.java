package com.spring.redis.service;

import com.spring.redis.entity.Product;

public interface IProductService {


    Product getProduct(Integer id);

    void reduceStock(Integer id);

}
