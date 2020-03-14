package com.f139.aop.service;

import com.f139.aop.pojo.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUser(Integer id) {
        return User.builder().id(id).name("wang").build();
    }
}
