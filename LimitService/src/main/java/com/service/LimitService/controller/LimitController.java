package com.service.LimitService.controller;

import com.service.LimitService.bean.Limits;
import com.service.LimitService.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/getLimits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
//        return new Limits(1,1000);
    }
}
