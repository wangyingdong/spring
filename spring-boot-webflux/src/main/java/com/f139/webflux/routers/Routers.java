package com.f139.webflux.routers;


import com.f139.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;


@Configuration
public class Routers {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> userRouter() {
        return RouterFunctions.nest(
                RequestPredicates.path("/router/user/"),
                RouterFunctions.route(RequestPredicates.GET("/"), userHandler::getAllUser)
                        .andRoute(RequestPredicates.POST("/").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), userHandler::createUser)
                        .andRoute(RequestPredicates.DELETE("/{id}"), userHandler::deleteUser)

        );
    }


}
