package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试服务降级
 * 这里找不到类
 *
 * @author zhigang.peng
 * @date 2021/5/16
 */
@RestController
public class ServiceDegradationController {

    @GetMapping("/staticHello")
    public String helloWorld() {
        return "托底数据为：" + "hello world";
    }


}
