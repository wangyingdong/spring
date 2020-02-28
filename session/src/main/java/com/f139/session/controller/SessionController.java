package com.f139.session.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.f139.session.entity.User;
import com.f139.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class SessionController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/session")
    public String getSession(HttpServletRequest request) {

        User user = User.builder().id(1L).username("wangyingdong").password("888888").build();

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
