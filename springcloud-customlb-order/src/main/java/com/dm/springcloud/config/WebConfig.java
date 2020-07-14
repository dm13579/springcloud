package com.dm.springcloud.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 */
@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate(DiscoveryClient discoveryClient) {
        return new DmRestTemplate(discoveryClient);
    }
}
