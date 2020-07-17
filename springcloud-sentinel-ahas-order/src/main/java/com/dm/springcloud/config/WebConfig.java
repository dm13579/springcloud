package com.dm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * restTemplate配置
 * 开启ribbon负载均衡--加入LoadBalanced
 * 开启sentinel限流流控--加入SentinelRestTemplate
 * --blockHandler处理BlockException 限流了
 * --fallback 熔断降级了
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @LoadBalanced
//    @SentinelRestTemplate(
//            blockHandler = "handleException",blockHandlerClass = GlobalExceptionHandler.class,
//            fallback = "fallback",fallbackClass = GlobalExceptionHandler.class
//    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
