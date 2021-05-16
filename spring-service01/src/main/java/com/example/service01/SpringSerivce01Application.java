package com.example.service01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhigang.peng
 * @date 2021/5/15
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringSerivce01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSerivce01Application.class);
    }
}
