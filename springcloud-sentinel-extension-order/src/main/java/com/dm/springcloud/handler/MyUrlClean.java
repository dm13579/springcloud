package com.dm.springcloud.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 解决RestFule风格的请求
 * eg:/selectOrderInfoById/2     /selectOrderInfoById/1 需要转为/selectOrderInfoById/{number}
 */
//@Component
@Slf4j
public class MyUrlClean implements UrlCleaner {
    @Override
    public String clean(String originUrl) {
        log.info("originUrl:{}", originUrl);

        if (StringUtils.isEmpty(originUrl)) {
            log.error("originUrl not be null");
            throw new IllegalArgumentException("originUrl not be null");
        }
        return replaceRestfulUrl(originUrl);
    }

    /**
     * 方法实现说明:把/selectOrderInfoById/2 替换成/selectOrderInfoById/{number}
     *
     * @param sourceUrl 目标url
     * @author:smlz
     * @return: 替换后的url
     * @exception:
     * @date:2019/12/4 13:46
     */
    private String replaceRestfulUrl(String sourceUrl) {
        List<String> origins = Arrays.asList(sourceUrl.split("/"));
        StringBuffer targetUrl = new StringBuffer("/");

        for (String str : origins) {
            if (NumberUtils.isNumber(str)) {
                targetUrl.append("/{number}");
            } else {
                targetUrl.append(str);
            }

        }
        return targetUrl.toString();
    }
}
