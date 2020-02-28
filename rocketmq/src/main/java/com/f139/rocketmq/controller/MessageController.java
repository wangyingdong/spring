package com.f139.rocketmq.controller;


import com.f139.rocketmq.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private IMessageService messageService;


    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public void sendMessage() {
        messageService.sendMessage();
    }



}
