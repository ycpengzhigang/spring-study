package com.example.service01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhigang.peng
 * @date 2021/5/16
 */
@RestController
public class FromGatewaySetPath {

    /**
     * 测试网关的占位符的路径的情况 不能使用多级 /a/b的情况
     *
     * @return
     */
    @GetMapping("/testSetPathFromGateway")
    public String testSetPathFromGateway() {
        System.out.println("hello world set path");
        return "hello world";
    }


}
