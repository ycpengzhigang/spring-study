package com.example.sentinel.fegin;

import com.example.sentinel.SentinelSerivceDemo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhigang.peng
 * @date 2021/7/14
 */
@RestController
public class SentinelServiceDemoImpl implements SentinelSerivceDemo {

    /**
     * 会进行数据更新
     *
     * @param param
     * @return
     */
    @Override
    public String say(String param) {
        return "hello" + param;
    }

}
