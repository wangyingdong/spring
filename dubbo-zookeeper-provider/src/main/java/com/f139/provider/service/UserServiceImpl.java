package com.f139.provider.service;

import com.f139.impl.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;


@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Value("${dubbo.protocol.port}")
    private Integer servicePort;


    public List<String> sayHello() {
        return Arrays.asList(serviceName, servicePort.toString(), "hello", "dubbo");
    }
}
