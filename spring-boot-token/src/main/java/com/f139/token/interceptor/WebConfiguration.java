package com.f139.token.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;


@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Resource
    private  ApiIdempotentInterceptor apiIdempotentInterceptor;

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiIdempotentInterceptor);
        super.addInterceptors(registry);
    }



}
