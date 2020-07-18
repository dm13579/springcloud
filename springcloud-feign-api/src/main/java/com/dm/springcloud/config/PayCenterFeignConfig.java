package com.dm.springcloud.config;

import com.dm.springcloud.handle.DmRequestInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * feign基本配置
 */
public class PayCenterFeignConfig {

    @Bean
    public Logger.Level level() {
//        return Logger.Level.FULL;
//        return Logger.Level.HEADERS;
        return Logger.Level.BASIC;
//        return Logger.Level.NONE;
    }

    /**
     * 根据SpringBoot自动装配FeignClientsConfiguration 的FeignClient的契约是SpringMvc
     *
     通过修改契约为默认的Feign的锲约，那么就可以使用默认的注解
     * @return
     */
//    @Bean
//    public Contract feiContract() {
//        return new Contract.Default();
//    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new DmRequestInterceptor();
    }

}
