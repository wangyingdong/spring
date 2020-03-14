package com.f139.token.serivce.impl;

import com.f139.token.redis.RedisService;
import com.f139.token.serivce.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    private String TOKEN_PREFIX = "token";


    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString().replace("-", "");
        StringBuffer token = new StringBuffer();
        token.append(TOKEN_PREFIX).append(":").append(str);
        redisService.setEx(token.toString(), token.toString(), 10000l);
        return str;
    }

    @Override
    public Boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_PREFIX);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(TOKEN_PREFIX);
            if (StringUtils.isEmpty(token)) {
                throw new RuntimeException("token is empty");
            }
        }
        StringBuffer s = new StringBuffer();
        s.append(TOKEN_PREFIX).append(":").append(token);
        if (!redisService.exists(s.toString())) {
            throw new RuntimeException("token is not exists");
        }
        Boolean result = redisService.remove(s.toString());
        if (!result) {
            throw new RuntimeException("token remove fail");
        }
        return result;
    }
}
