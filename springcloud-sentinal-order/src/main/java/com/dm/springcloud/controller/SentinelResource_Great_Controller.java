package com.dm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dm.springcloud.controller.handler.GlobalFallbackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试SentinelResource的注解
 */
@RestController
@Slf4j
public class SentinelResource_Great_Controller {


    @SentinelResource(value = "testSentinelResourceGreat",
            //blockHandlerClass = GlobalBlockHandler.class,
            fallbackClass = GlobalFallbackHandler.class,
            //blockHandler = "blockHandlerMethod"
            fallback = "fallBackHandlerMethod"
    )
    @RequestMapping("/testSentinelApi-great")
    public String testSentinelResource(@RequestParam(value = "testParam",required = false) String testParam) throws InterruptedException {

/*        if(testParam == null) {
            throw new IllegalArgumentException("param can not be null");
        }*/
        Thread.sleep(200);
        return "you param is:"+testParam;
    }
}
