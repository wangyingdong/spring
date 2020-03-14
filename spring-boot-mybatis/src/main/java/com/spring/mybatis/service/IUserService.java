package com.spring.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.spring.mybatis.entity.Page;
import com.spring.mybatis.entity.User;

import java.util.List;


public interface IUserService {


    PageInfo<User> queryUser(Page page, User user);

    List<User> listUser();


    User getUser(Integer id);

    Integer saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}
