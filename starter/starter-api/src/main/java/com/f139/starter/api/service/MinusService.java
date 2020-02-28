package com.f139.starter.api.service;

import com.f139.starter.api.exception.MinusException;

public interface MinusService {

    int minus(int minuend, int subtraction) throws MinusException;

}
