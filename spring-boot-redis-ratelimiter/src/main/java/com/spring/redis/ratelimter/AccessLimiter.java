package com.spring.redis.ratelimter;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Deprecated
public class AccessLimiter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisScript<Boolean> rateLimitLua;


    public void limiter(String key, Integer limit) {
        // step 1 : request lua script
        boolean acquired = stringRedisTemplate.execute(
                rateLimitLua, // lua script
                Lists.newArrayList(key), //lua key 列表
                limit.toString() //lua value 列表
        );


        if (!acquired) {
            log.error("your access is blocked, key is {}", key);
            throw new RuntimeException("your access is blocked");
        }


    }

}
