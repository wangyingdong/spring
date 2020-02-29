package com.f139.token.serivce;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {


    public String createToken();

    public Boolean checkToken(HttpServletRequest request);

}
