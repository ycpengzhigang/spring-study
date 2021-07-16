package com.example.sentinel;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */
public class OnionRequestInterceptor implements RequestInterceptor {

    /**
     * token自定义的形式
     */
    private static final String ACCESS_TOKEN_VALUE = "12333333344455566778899";

    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    private static final String APP_SRC_VALUE = "onion";

    private static final String APP_SRC = "onion";

    @Override
    public void apply(RequestTemplate template) {
        // TODO
        // 先从头部获取到ACCESS_TOKEN 在放入到后面进行传递
        // 设置token
        template.header(ACCESS_TOKEN, ACCESS_TOKEN_VALUE);
        // 设置来源
        template.header(APP_SRC, APP_SRC_VALUE);
    }
}
