package com.spring.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.f139.mybatis")
public class SpringMybatisBoot {


    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisBoot.class);
    }
}
