package com.dm.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.feignapi.sentinel.ProductCenterFeignApiWithSentinel;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 异常处理类
 * 可根据异常去配不同的返回信息
 */
@Component
@Slf4j
public class ProductCenterFeignApiWithSentielFallbackFactory implements FallbackFactory<ProductCenterFeignApiWithSentinel> {
    @Override
    public ProductCenterFeignApiWithSentinel create(Throwable throwable) {
        return new ProductCenterFeignApiWithSentinel(){

            @Override
            public ProductInfo selectProductInfoById(String productNo) {

                ProductInfo productInfo = new ProductInfo();
                if(throwable instanceof FlowException){
                    log.error("原因:{流控}",throwable);
                    productInfo.setProductName("我是被流控的默认商品");
                }
                if(throwable instanceof DegradeException){
                    log.error("原因:{熔断降级}",throwable);
                    productInfo.setProductName("我是被降级的默认商品");
                }
                return productInfo;
            }
        };
    }
}
