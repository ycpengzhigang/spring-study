package com.example.service01.controller;

import com.example.service01.service.FeginTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */
@RestController
public class FeginTestController {

    @Autowired
    private FeginTestService feginTestService;

    @GetMapping("sayHello/{name}")
    public String sayHello(@PathVariable String name) {
        return feginTestService.testSay(name);
    }

}
