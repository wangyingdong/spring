package com.f139.session.service;


import com.f139.session.entity.User;
import com.f139.session.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    ApplicationContext applicationContext;


    public void reg(User user) {
        applicationContext.publishEvent(new UserEvent(this, user));
    }


}
