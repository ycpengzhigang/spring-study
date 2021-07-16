package com.example.service01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhigang.peng
 * @date 2021/5/15
 */
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.example.**")
@SpringBootApplication
public class SpringService01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringService01Application.class);
    }
}

