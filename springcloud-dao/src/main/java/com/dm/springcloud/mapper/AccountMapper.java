package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 账号apper
 */
public interface AccountMapper {

    /**
     * 扣减账户余额
     * @param userId
     * @param balance
     * @return
     */
    Integer reduceBalance(@Param("userId") Integer userId, @Param("balance") BigDecimal balance);

    Account selectByUserId(@Param("userId") Integer userId);
}
