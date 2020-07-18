package com.dm.springcloud.feignapi.productcenter;

import com.dm.springcloud.config.PayCenterFeignConfig;
import com.dm.springcloud.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 支付Feign调用
 */
@FeignClient(name = "pay-center", configuration = PayCenterFeignConfig.class)
public interface PayCenterFeignApi {

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/reduceBalance")
    Result reduceBalance(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
