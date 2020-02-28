package com.f139.starter.service;

import com.f139.starter.api.exception.MinusException;
import com.f139.starter.api.service.MinusService;

public class MinusServiceNotSupportNegativeImpl implements MinusService {



    public int minus(int minuend, int subtraction) throws MinusException {
        if(subtraction>minuend){
            throw new MinusException("not support negative!");
        }

        return minuend-subtraction;
    }
}
