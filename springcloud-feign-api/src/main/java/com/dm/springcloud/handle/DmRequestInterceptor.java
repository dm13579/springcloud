package com.dm.springcloud.handle;

import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Request拦截器
 * 让通过feign调用将token往后续的微服务传
 */
public class DmRequestInterceptor implements feign.RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        template.header("Token",request.getHeader("Token"));
    }
}
