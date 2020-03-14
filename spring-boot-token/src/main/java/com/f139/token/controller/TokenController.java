package com.f139.token.controller;


import com.f139.token.annotation.AutoIdempotent;
import com.f139.token.serivce.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/token")
@Slf4j
public class TokenController {

    @Resource
    private TokenService tokenService;


    @GetMapping
    public String token() {
        return tokenService.createToken();
    }


    @AutoIdempotent
    @PostMapping("idempotent")
    public String idempotent() {
        return "ok";
    }

}
