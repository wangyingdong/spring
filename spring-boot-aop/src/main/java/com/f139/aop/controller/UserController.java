package com.f139.aop.controller;


import com.f139.aop.pojo.User;
import com.f139.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User user(@PathVariable Integer id) {
        return userService.getUser(id);
    }

}

