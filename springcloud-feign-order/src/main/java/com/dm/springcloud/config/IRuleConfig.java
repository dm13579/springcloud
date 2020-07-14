package com.dm.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon负载均衡规则
 */
@Configuration
public class IRuleConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
