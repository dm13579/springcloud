package com.dm.springcloud.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 类的描述:区分来源接口
 */
@Component
@Slf4j
public class MyRequestOriginParse implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        String origin = request.getHeader("origin");
        if (StringUtils.isEmpty(origin)) {
            log.warn("origin must not null");
            throw new IllegalArgumentException("request origin must not null");
        }
        return origin;
    }
}
