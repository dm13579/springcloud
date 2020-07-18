package com.dm.springcloud.feignapi.productcenter;

import com.dm.springcloud.config.ProductCenterFeignConfig;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品Feign调用
 */
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

    @GetMapping(value = "/reduceCount")
    Result reduceCount(@RequestParam("productNo") String productNo, @RequestParam("count") Integer count);

}
