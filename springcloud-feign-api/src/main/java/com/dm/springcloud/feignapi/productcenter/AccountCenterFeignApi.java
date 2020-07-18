package com.dm.springcloud.feignapi.productcenter;

import com.dm.springcloud.config.AccountCenterFeignConfig;
import com.dm.springcloud.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-server" , configuration = AccountCenterFeignConfig.class)
public interface AccountCenterFeignApi {

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/reduceBalance")
    Result reduceBalance(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);
}
