package com.example.sentinel;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhigang.peng
 * @date 2021/7/17
 */
@Service
public class SentinelFallback implements SentinelSerivceFallBack {

    @Override
    @GetMapping(SENTINEL_PREFIX + "/say")
    public String say(String param) {
        return "error :" + param;
    }
}
