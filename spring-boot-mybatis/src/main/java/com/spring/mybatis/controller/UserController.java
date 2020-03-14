package com.spring.mybatis.controller;


import com.github.pagehelper.PageInfo;
import com.spring.mybatis.entity.Page;
import com.spring.mybatis.entity.User;
import com.spring.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
public class UserController {


    @Autowired
    public IUserService userService;


    @GetMapping(value = "/user/query")
    public PageInfo<User> queryUser(Page page, User user) {
        return userService.queryUser(page, user);
    }

    @GetMapping(value = "/user/list")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }


    @PostMapping(value = "/user/save")
    public Integer saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/user/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}
