package com.f139.session.listeners;

import com.f139.session.entity.User;
import com.f139.session.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class AnnotationRegisterListener {

    /**
     * 注册监听实现方法
     */
    @EventListener
    public void register(UserEvent userEvent) {
        //获取注册用户对象
        User user = userEvent.getUser();
        //输出注册用户信息
        System.out.println("@EventListener注册信息，用户名：" + user.getUsername() + "，密码：" + user.getPassword());
    }
}
