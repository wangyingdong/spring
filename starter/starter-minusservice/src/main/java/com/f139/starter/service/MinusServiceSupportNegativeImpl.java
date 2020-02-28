package com.f139.starter.service;

import com.f139.starter.api.exception.MinusException;
import com.f139.starter.api.service.MinusService;

public class MinusServiceSupportNegativeImpl implements MinusService {

    public int minus(int minuend, int subtraction) throws MinusException {
        return minuend - subtraction;
    }
}
