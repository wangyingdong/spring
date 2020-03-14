package com.f139.redis.controller;

import com.alibaba.fastjson.JSON;
import com.f139.redis.config.RedisClientUtil;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    RedisClientUtil redisClientUtil;


    @RequestMapping("/set")
    public void set() {
        User user = User.builder().id(1).name("hello").build();
        redisClientUtil.setVal("user", user);
        redisClientUtil.setVal("test", 4321);
        redisClientUtil.setHashMapVal("中国", "江苏", "无锡");

    }

    @RequestMapping("/get")
    public String get() {
        String s = (redisClientUtil.getVal("test").toString());
        User user = (User) (redisClientUtil.getVal("user"));
        Map<String, String> map = (Map<String, String>) redisClientUtil.getHashVal("中国");
        System.out.println(JSON.toJSON(map));
        return user.getName();
    }

}


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Serializable {
    private Integer id;
    private String name;
}
