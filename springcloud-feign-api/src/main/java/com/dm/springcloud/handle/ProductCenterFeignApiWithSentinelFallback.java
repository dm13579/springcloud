package com.dm.springcloud.handle;

import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.feignapi.sentinel.ProductCenterFeignApiWithSentinel;
import org.springframework.stereotype.Component;

/**
 * 异常处理类
 * 只能单一因为不知道是什么异常
 */
@Component
public class ProductCenterFeignApiWithSentinelFallback implements ProductCenterFeignApiWithSentinel {
    @Override
    public ProductInfo selectProductInfoById(String productNo) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("默认商品");
        return productInfo;
    }
}
