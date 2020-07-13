package com.dm.springcloud.controller;

import com.dm.springcloud.entity.PayInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.PayInfoMapper;
import com.dm.springcloud.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smlz on 2019/11/17.
 */
@Slf4j
@RestController
public class PayInfoController {

    @Autowired
    private PayInfoMapper payInfoMapper;

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payInfoMapper.selectPayInfoByOrderNo(orderNo);
    }

    @RequestMapping("/save")
    public String savePayInfo(@RequestBody PayInfo payInfo) {
        log.info("payInfo:{}",payInfo);
        return payInfo.getOrderNo();
    }
 }
