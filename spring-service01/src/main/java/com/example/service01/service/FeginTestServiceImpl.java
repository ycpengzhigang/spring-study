package com.example.service01.service;

import com.example.sentinel.SentinelSerivceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */
@Service
public class FeginTestServiceImpl implements FeginTestService {

    @Autowired
    private SentinelSerivceDemo sentinelSerivceDemo;

    @Override
    public String testSay(String param) {
        return sentinelSerivceDemo.say(param);
    }
}
