package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhigang.peng
 * @date 2021/5/15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGatewayApplication.class, args);
    }

}
