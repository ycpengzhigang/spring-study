package com.example.sentinel;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */
@Configuration
public class FeignConfiguration {

    /**
     * 根据实际情况调整 做到可配置
     *
     * @return
     */
    @Bean("feignLoggerLevel")
    @Profile("dev")
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean("feignLoggerLevel")
    @Profile("test")
    public Logger.Level feignLoggerLevelTest() {
        return Logger.Level.NONE;
    }

    /**
     * 设置请求头部
     *
     * @return
     */
    @Bean
    public RequestInterceptor onionRequestInterceptor() {
        return new OnionRequestInterceptor();
    }
}
