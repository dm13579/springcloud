package com.dm.springcloud.feignapi.sentinel;

import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.handle.ProductCenterFeignApiWithSentielFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * sentinel 商品Feign调用
 */
//@FeignClient(name = "product-center",fallback = ProductCenterFeignApiWithSentinelFallback.class)
@FeignClient(name = "product-center",fallbackFactory = ProductCenterFeignApiWithSentielFallbackFactory.class)
public interface ProductCenterFeignApiWithSentinel {

    /**
     * 声明式接口,远程调用http://product-center/selectProductInfoById/{productNo}
     * @param productNo
     * @return
     */
    @RequestMapping("/selectProductInfoById/{productNo}")
    ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo);

}
