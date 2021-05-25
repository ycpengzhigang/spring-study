package com.example.hystrix.callback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * {@link https://www.cnblogs.com/yepei/p/7169127.html}
 * 测试降级策略
 *
 * @author zhigang.peng
 * @date 2021/5/25
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommand(String name) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey
                        .Factory
                        .asKey("HelloWorldGroup"))
                //  配置依赖超时时间,500毫秒
                .andCommandPropertiesDefaults(HystrixCommandProperties
                        .Setter()
                        .withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }

    public static void main(String[] args) {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("test-fallback");
        String result = helloWorldCommand.execute();
    }

    @Override
    public String getFallback() {
        return "execute Falled";
    }

    @Override
    protected String run() throws Exception {
        // sleep 1 秒,调用会超时
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name + " thread:" + Thread.currentThread().getName();
    }
}
