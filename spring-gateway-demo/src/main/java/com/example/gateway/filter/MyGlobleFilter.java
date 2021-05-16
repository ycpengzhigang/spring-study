package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义 全局拦截器
 * {@link GlobalFilter}
 *
 * @author zhigang.peng
 * @date 2021/5/16
 */
@Component
public class MyGlobleFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("自定义全局过滤器 处理前");
        Mono<Void> result = chain.filter(exchange);
        System.out.println("自定义全局过滤器 处理后");
        return result;
    }

}
