package com.spring.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mybatis.entity.Page;
import com.spring.mybatis.entity.User;
import com.spring.mybatis.mapper.UserMapper;
import com.spring.mybatis.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements IUserService {


    @Resource
    public UserMapper userMapper;


    //https://github.com/abel533/Mapper/wiki/6.example

    @Override
    public PageInfo<User> queryUser(Page page, User user) {

        Example example = new Example(User.class);

        example.setOrderByClause("id");

        if (!Objects.isNull(user)) {
            if (!StringUtils.isEmpty(user.getUsername())) {
                example.and().andEqualTo("username", user.getUsername());
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                example.and().andLike("email", "%" + user.getEmail() + "%");
            }

        }

        return PageHelper.startPage(page).doSelectPageInfo(() -> userMapper.selectByExample(example));
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.selectOne(User.builder().id(id).build());
    }

    @Override
    public Integer saveUser(User user) {
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(User.builder().id(id).build());
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
