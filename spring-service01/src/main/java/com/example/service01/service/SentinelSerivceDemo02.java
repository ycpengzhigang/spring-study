package com.example.service01.service;

import com.example.sentinel.SentinelSerivceDemo;
import org.springframework.stereotype.Service;

/**
 * 测试fegin的primary
 *
 * @author zhigang.peng
 * @date 2021/7/16
 */
@Service
public class SentinelSerivceDemo02 implements SentinelSerivceDemo {

    @Override
    public String say(String param) {
        return "hello error";
    }
}
