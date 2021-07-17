package com.example.sentinel.fegin;

import com.example.sentinel.SentinelSerivceFallBack;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhigang.peng
 * @date 2021/7/17
 */
@RestController
public class SentinelSerivceFallBackImpl implements SentinelSerivceFallBack {

    @Override
    public String say(String param) {

        throw new RuntimeException("模拟容错处理的情况");
//        return "fall back hello:" + param;
    }
}
