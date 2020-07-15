package com.dm.springcloud.feignapi.sentinel;

import com.dm.springcloud.entity.ProductInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 商品sentinal Feign调用
 */
//@FeignClient(name = "product-center",fallback = ProductCenterFeignApiWithSentinelFallback.class)
//@FeignClient(name = "product-center",fallbackFactory = ProductCenterFeignApiWithSentielFallbackFactory.class)
public interface ProductCenterFeignApiWithSentinel {

    /**
     * 声明式接口,远程调用http://product-center/selectProductInfoById/{productNo}
     * @param productNo
     * @return
     */
    @RequestMapping("/selectProductInfoById/{productNo}")
    ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo);

}
