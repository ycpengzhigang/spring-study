package com.example.sentinel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-sentinel", configuration = FeignConfiguration.class, contextId = "fegin-context")
public interface SentinelSerivceDemo {

    String SENTINEL_PREFIX = "/sentinel/demo";

    @GetMapping(SENTINEL_PREFIX + "/say")
    String say(@RequestParam String param);
}
