package com.f139.redis.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.apache.commons.collections.CollectionUtils;

/**
 * reids 客户端工具类
 */
@ConditionalOnProperty(value = "spring.redis.host")
@Component
public class RedisClientUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public Object getVal(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public List<Object> getVal(Collection<String> keys) {
        List<Object> vals = redisTemplate.opsForValue().multiGet(keys);
        // 排除null值的元素
        vals.removeAll(Collections.singleton(null));
        return vals;
    }


    public void setVal(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }


    public void multiSetVal(Map<String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
    }


    public void setValWithTimeout(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


    public void setHashMapVal(String key, Object mapKey, Object mapVal) {
        redisTemplate.opsForHash().put(key, mapKey, mapVal);
    }


    public Object getHashMapVal(String key, Object mapKey) {
        return redisTemplate.opsForHash().get(key, mapKey);
    }

    public Object getHashVal(String key) {
        return redisTemplate.opsForHash().entries(key);
    }


    public void setExpireTime(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public void del(String key) {
        redisTemplate.delete(key);
    }

    public void del(Collection<String> keys) {
        redisTemplate.delete(keys);
    }


    public void deleteByPrex(String prex) {
        Set<String> keys = redisTemplate.keys(prex);
        if (CollectionUtils.isNotEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }


    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }


    public Set<String> keys(String keys) {
        return redisTemplate.keys(keys);
    }


    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
