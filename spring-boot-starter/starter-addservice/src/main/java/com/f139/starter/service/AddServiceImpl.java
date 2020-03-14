package com.f139.starter.service;

import com.f139.starter.api.service.AddService;

public class AddServiceImpl implements AddService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
