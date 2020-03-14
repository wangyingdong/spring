package com.f139.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSentinelGatewayApplication {


    public static void main(String[] args) {

        SpringApplication.run(NacosSentinelGatewayApplication.class, args);
    }



}
