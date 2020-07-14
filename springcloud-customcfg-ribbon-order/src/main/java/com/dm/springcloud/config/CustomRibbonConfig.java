package com.dm.springcloud.config;

import com.dm.ribbonconfig.GlobalRibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon的配置
 */
@Configuration
/*@RibbonClients(value = {
        @RibbonClient(name = "product-center",configuration = ProductCenterRibbonConfig.class),
        @RibbonClient(name = "pay-center",configuration = PayCenterRibbonConfig.class)
})*/
@RibbonClients(defaultConfiguration = GlobalRibbonConfig.class)
public class CustomRibbonConfig {

}
