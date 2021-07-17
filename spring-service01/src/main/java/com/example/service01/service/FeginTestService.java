package com.example.service01.service;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */

public interface FeginTestService {

    String testSay(String param);

    String testSentinelFallback(String param);
}
