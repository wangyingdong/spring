package com.spring.redis.ratelimter.annotation;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class AccessLimiterAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisScript<Boolean> rateLimitLua;


    @Pointcut("@annotation(com.spring.redis.ratelimter.annotation.AccessLimiter)")
    public void cut() {
        log.info("cut");
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        //1、获得方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AccessLimiter annotation = method.getAnnotation(AccessLimiter.class);
        if (annotation == null) {
            return;

        }
        String key = annotation.methodKey();
        Integer limit = annotation.limit();

        //如果没有设置methodKey,从调用的方法签名自动生成一个key
        if (StringUtils.isEmpty(key)) {
            key = method.toString();
        }

        //2、调用rediss
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
