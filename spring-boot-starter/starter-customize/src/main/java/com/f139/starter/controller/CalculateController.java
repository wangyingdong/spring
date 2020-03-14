package com.f139.starter.controller;

import com.f139.starter.anotation.AnalysisActuator;
import com.f139.starter.api.exception.MinusException;
import com.f139.starter.api.service.AddService;
import com.f139.starter.api.service.MinusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @Autowired
    private AddService addService;

    @Autowired
    private MinusService minusService;

    @AnalysisActuator(note = "加法")
    @RequestMapping(value = "/add/{added}/{add}", method = RequestMethod.GET)
    public String add(@PathVariable("added") int added, @PathVariable("add") int add) {
        return added + " 加 " + add + " 等于 : " + addService.add(added, add);
    }

    @AnalysisActuator(note = "减法")
    @RequestMapping(value = "/minus/{minuend}/{subtraction}", method = RequestMethod.GET)
    public String minus(@PathVariable("minuend") int minuend, @PathVariable("subtraction") int subtraction) throws MinusException {
        return minuend + " 减 " + subtraction + " 等于 : " + minusService.minus(minuend, subtraction);
    }
}