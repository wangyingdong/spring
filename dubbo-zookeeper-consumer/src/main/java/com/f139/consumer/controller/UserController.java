package com.f139.consumer.controller;


import com.f139.impl.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;


    @GetMapping(value="/hello")
    public List<String> hello() {
        return userService.sayHello();
    }
}
