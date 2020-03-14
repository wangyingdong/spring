package com.f139.webflux;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class WebfluxAppliaction {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebfluxAppliaction.class, args);
    }

}
