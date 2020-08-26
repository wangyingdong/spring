package com.f139.mqtt.controller;


import com.f139.mqtt.service.MqttSendServer;
import com.f139.mqtt.vo.MqttaAuthVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/mqtt")
@Slf4j
public class MqttController {


    private ResponseEntity<Void> AUTH_PASS = ResponseEntity.status(HttpStatus.OK).build();
    private ResponseEntity<Void> AUTH_REJECT = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    @Autowired
    private MqttSendServer mqttSendServer;

    /**
     * auth：是在每次登录是都会验证一次。
     * superuser：会在登录的时候调用判断是否有超级用户权限
     * acl：这个会在发布或订阅数据的时候请求，判断是否允许发布或订阅，不会每次都判断，只对新Topic才进行判断，然后缓存在EMQ里面。
     */

    @PostMapping("/auth")
    @ResponseBody
    public void auth(MqttaAuthVo mqttaAuthVo, HttpServletResponse response) {
        log.info("auth:{}", mqttaAuthVo);
        response.setStatus(HttpStatus.OK.value());
    }

    @PostMapping("/superuser")
    @ResponseBody
    public void superuser(MqttaAuthVo mqttaAuthVo, HttpServletResponse response) {
        log.info("superuser:{}", mqttaAuthVo);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }


    @ResponseBody
    @GetMapping("/acl")
    public void acl(MqttaAuthVo mqttaAuthVo, HttpServletResponse response) {
        log.info("acl:{}", mqttaAuthVo);
        response.setStatus(HttpStatus.OK.value());
    }


    @GetMapping("/send")
    public HttpStatus send(String message) {
        mqttSendServer.sendToMqtt(message + "-" + LocalDateTime.now(), "topic");
        return HttpStatus.OK;
    }


}
