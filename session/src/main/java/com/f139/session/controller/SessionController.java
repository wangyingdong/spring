package com.f139.session.controller;


import com.alibaba.fastjson.JSON;
import com.f139.session.entity.User;
import com.f139.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
public class SessionController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/session/{username}")
    public String getSession(@PathVariable String username, HttpServletRequest request) {
        User user = User.builder().id(1L).username(username).password("888888").build();
        HttpSession session = request.getSession();//这就是session的创建
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(60 * 1);
        return session.getId();
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public String get(HttpServletRequest request) {
        Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("user");
        User user = JSON.parseObject(JSON.toJSONString(map), User.class);
        return user.getUsername();
    }

    @ResponseBody
    @RequestMapping(value = "/reg")
    public String reg(HttpServletRequest request) {
        User user = User.builder().id(1L).username("wangyingdong").password("888888").build();
        userService.reg(user);
        return "ok";
    }

}
