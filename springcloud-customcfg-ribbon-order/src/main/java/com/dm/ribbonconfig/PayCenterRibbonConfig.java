package com.dm.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Configuration;

/**
 * 支付服务Ribbon配置类
 */
@Configuration
public class PayCenterRibbonConfig {

    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
