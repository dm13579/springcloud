package com.dm.springcloud.controller;

import com.dm.springcloud.mapper.ProductInfoMapper;
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
@Slf4j
public class ProductController {

    @Autowired
    private ProductInfoMapper productMapper;

    @PostMapping("/reduceCount")
    public Result decrease(@RequestParam Integer count, @RequestParam String productNo) throws Exception {
        log.info("商品Id:{},商品数量:{}",productNo,count);
        log.info("当前 XID: {}", RootContext.getXID());
        // 检查库存
        checkStock(productNo, count);
        log.info("开始扣减 {} 库存", productNo);
        //Integer record = productMapper.reduceCountByBatch(Arrays.asList(1,2));
        Integer record = productMapper.reduceCount(productNo,count);
        //Integer record2 = productMapper.reduceCount(productId,amount);

        log.info("结束扣减 {} 库存结果:{}", productNo, record > 0 ? "操作成功" : "扣减库存失败");

        if(record > 0) {
            return Result.success("扣除库存成功");
        }else{
            return Result.fail("扣款失败");
        }
    }

    private void checkStock(String productNo, Integer requiredAmount) throws Exception {
        log.info("检查 {} 库存", productNo);
        int countInDb = productMapper.selectCountById(productNo);
        log.info("数据库库存:{}",countInDb);
        if (countInDb < requiredAmount) {
            log.warn("{} 库存不足，当前库存:{}", productNo, countInDb);
            throw new Exception("库存不足");
        }
    }
}

