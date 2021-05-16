package com.example.gateway.limiter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 通过redis实现令牌桶的方式进行服务限流
 *
 * @author zhigang.peng
 * @date 2021/5/16
 */
@Component
public class PathAsKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        // 可以使用jmeter工具进行测试
        System.out.println("host:" + exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        return Mono.just(exchange.getRequest().getPath().toString());
    }

}
