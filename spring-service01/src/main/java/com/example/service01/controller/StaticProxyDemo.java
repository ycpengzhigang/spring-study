package com.example.service01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhigang.peng
 * @date 2021/5/15
 */
@RestController
public class StaticProxyDemo {

    @GetMapping("/staticProxy")
    public String testRequestOne() {
        System.out.println("hello world:");
        return "hello world";
    }


    @GetMapping("/staticHeader")
    public String testRequestHeader(@RequestHeader("name") String name) {
        System.out.println("hello world:" + name);
        return "hello world";
    }

    @GetMapping("/staticParameter")
    public String testRequestParameter(@RequestParam("eat") String eat) {
        System.out.println("static parameter:" + eat);
        return "hello world";
    }

    @GetMapping("/staticResponse")
    public String testResponseHeader(@RequestParam("eat") String eat, HttpServletResponse response) {
        response.setHeader("res", "resFirst");
        System.out.println("static parameter:" + eat);
        return "hello world";
    }

    /**
     * 测试网关跳过path中的指定路径前缀 从1开始计算
     *
     * @return
     */
    @GetMapping("/staticStripPrefix")
    public String testPathStripPrefix() {
        System.out.println("strip prefix");
        return "hello world";
    }


}
