package com.spring.mybatis.mapper;

import com.spring.mybatis.common.mapper.BasicMapper;
import com.spring.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BasicMapper<User> {


    List<User> listUser();

}