package com.dm.springcloud.feignapi.productcenter;

import com.dm.springcloud.config.ProductCenterFeignConfig;
import com.dm.springcloud.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-center", configuration = ProductCenterFeignConfig.class)
public interface ProductCenterFeignApi {

    /**
     * 声明式接口,远程调用http://product-center/selectProductInfoById/{productNo}
     * @param productNo
     * @return
     */
    @RequestMapping("/selectProductInfoById/{productNo}")
    ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo);

    @RequestMapping("/getToken4Header")
    String getToken4Header();
}
