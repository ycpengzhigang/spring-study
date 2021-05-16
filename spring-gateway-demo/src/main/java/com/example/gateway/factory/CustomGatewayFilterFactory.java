package com.example.gateway.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 自定义网关过滤器
 * 1、实现AbstractGatewayFilterFactory
 * 2、重写apply
 * 3、通过构造器的方式传入当前类的配置类
 * 4、在配置文件中进行配置
 * <p>
 * {@link AbstractGatewayFilterFactory}
 * {@link GatewayFilter}
 *
 * @author zhigang.peng
 * @date 2021/5/16
 */
@Component
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.CustomConfig> {

    public CustomGatewayFilterFactory() {
        // 加入当前类的配置类
        super(CustomConfig.class);
    }

    @Override
    public GatewayFilter apply(CustomConfig config) {
        return (exchange, chain) -> {
            // 在链式调用之前
            System.out.println("name:" + config.name);
            Mono<Void> mono = chain.filter(exchange);
            // 在链式调用之后
            System.out.println("age:" + config.age);
            return mono;
        };
    }

    /**
     * 自定义一个配置类
     */
    public static class CustomConfig {

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
