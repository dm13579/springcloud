package com.dm.springcloud.controller.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一处理降级类
 */
@Slf4j
public class GlobalFallbackHandler {

    /**
     * 用来处理容错降级的方法
     * @param testParam
     * @param ex
     * @return
     */
    public static String fallBackHandlerMethod(String testParam,Throwable ex) {
        log.info("被降级拉......"+ex.getMessage());
        return "invoke fallback......";
    }
}
