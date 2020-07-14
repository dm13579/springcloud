package com.dm.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 商品服务Ribbon配置类
 */
@Configuration
public class ProductCenterRibbonConfig {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
