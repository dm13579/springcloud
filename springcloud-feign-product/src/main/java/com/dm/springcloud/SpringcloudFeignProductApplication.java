package com.dm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudFeignProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignProductApplication.class, args);
    }
}
