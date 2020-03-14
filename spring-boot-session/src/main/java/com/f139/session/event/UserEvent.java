package com.f139.session.event;

import com.f139.session.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class UserEvent extends ApplicationEvent {

    private User user;

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
