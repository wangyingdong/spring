package com.f139.token.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean setEx(String key, String value, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean remove(String key) {
        Boolean result = false;
        if (exists(key)) {
            result = redisTemplate.delete(key);
        }
        return result;
    }

}
