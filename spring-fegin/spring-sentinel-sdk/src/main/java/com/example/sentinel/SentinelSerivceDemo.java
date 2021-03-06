package com.example.sentinel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这里面存在执行顺序
 * 配置了url和name将会直接执行url，他的优先级更高
 */
@FeignClient(name = "spring-sentinel", configuration = FeignConfiguration.class, contextId = "fegin-context", decode404 = true, url  ="http://localhost:8086")
public interface SentinelSerivceDemo {

    String SENTINEL_PREFIX = "/sentinel/demo";

    @GetMapping(SENTINEL_PREFIX + "/say")
    String say(@RequestParam String param);
}
