package com.spring.redis.controller;


import com.spring.redis.config.RedisClientUtil;
import com.spring.redis.entity.Product;
import com.spring.redis.service.IProductService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@ResponseBody
public class StockController {


    @Autowired
    RedisClientUtil redisClientUtil;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    IProductService productService;

    @RequestMapping("/miaosha")
    public Product miaosha(@RequestParam("id") Integer id) {
        RLock rlock = redissonClient.getLock(id.toString());
        rlock.lock(30, TimeUnit.SECONDS);
        try {
            int stock = ((Integer) redisClientUtil.getVal("stock"));
            if (stock > 0) {
                stock = stock - 1;
                redisClientUtil.setVal("stock", stock);
                productService.reduceStock(id);
                System.out.println("秒杀成功！");
            } else {
                throw new RuntimeException("库存不足!");
            }
        } finally {
            rlock.unlock();

        }
        return productService.getProduct(id);
    }


    @RequestMapping("/lock")
    public void lock(@RequestParam("id") Integer id) {
        redisClientUtil.tryLock("lock", 1000);
    }

}
