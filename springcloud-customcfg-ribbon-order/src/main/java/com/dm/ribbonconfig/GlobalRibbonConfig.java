package com.dm.ribbonconfig;

import com.dm.springcloud.myrule.TheSameClusterPriorityWithVersionRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局Ribbon配置类
 */
@Configuration
public class GlobalRibbonConfig {

    @Bean
    public IRule theSameClusterPriorityRule() {
//        return new MyWeightedRule();
//        return new TheSameClusterPriorityRule();
        return new TheSameClusterPriorityWithVersionRule();
    }
}
