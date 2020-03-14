package com.spring.mybatis;


import com.spring.mybatis.entity.User;
import com.spring.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisBootTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testList() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }


}
