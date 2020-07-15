package com.dm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl {

    @SentinelResource("common")
    public String common() {
        log.info("common.....");
        return "common";
    }
}
