package com.example.sentinel;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
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
