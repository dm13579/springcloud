package com.dm.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.feignapi.sentinel.ProductCenterFeignApiWithSentinel;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductCenterFeignApiWithSentielFallbackFactory implements FallbackFactory<ProductCenterFeignApiWithSentinel> {
    @Override
    public ProductCenterFeignApiWithSentinel create(Throwable throwable) {
        return new ProductCenterFeignApiWithSentinel(){

            @Override
            public ProductInfo selectProductInfoById(String productNo) {
                log.error("原因:{}",throwable);
                ProductInfo productInfo = new ProductInfo();
                if(throwable instanceof FlowException){
                    productInfo.setProductName("我是被流控的默认商品");
                }
                if(throwable instanceof DegradeException){
                    productInfo.setProductName("我是被降级的默认商品");
                }
                return productInfo;
            }
        };
    }
}
