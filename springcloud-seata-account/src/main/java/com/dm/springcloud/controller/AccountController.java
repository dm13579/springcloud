package com.dm.springcloud.controller;



import com.dm.springcloud.entity.Account;
import com.dm.springcloud.mapper.AccountMapper;
import com.dm.springcloud.vo.Result;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 账号Controller
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/reduceBalance")
    @ResponseBody
    public Result reduceBalance(@RequestParam("userId") Integer userId, @RequestParam("balance") BigDecimal balance) throws Exception {
        Result result = new Result();

        log.info("当前 XID: {}", RootContext.getXID());
        checkBalance(userId, balance);

        log.info("开始扣减用户 {} 余额", userId);
        //模拟异常
        Integer record = accountMapper.reduceBalance(userId, balance);

        System.out.println(1/0);

        log.info("结束扣减用户 {} 余额结果:{}", userId, record > 0 ? "操作成功" : "扣减余额失败");

        boolean reduceMoneyFlag = record > 0;


        if(record > 0) {
            return Result.success("扣款成功");
        }else{
            return Result.fail("扣款失败");
        }
    }

    private void checkBalance(Integer userId, BigDecimal price) throws Exception {
        log.info("检查用户 {} 余额", userId);
        Account account = accountMapper.selectByUserId(userId);

        if (account!=null) {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(price) == -1) {
                log.warn("用户 {} 余额不足，当前余额:{}", userId, balance);
                throw new Exception("余额不足");
            }
        }
    }
}

