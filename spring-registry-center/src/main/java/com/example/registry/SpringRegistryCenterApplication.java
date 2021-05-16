package com.example.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhigang.peng
 * @date 2021/5/15
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringRegistryCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRegistryCenterApplication.class);
    }

}
