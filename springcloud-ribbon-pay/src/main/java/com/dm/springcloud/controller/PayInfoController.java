package com.dm.springcloud.controller;

import com.dm.springcloud.entity.PayInfo;
import com.dm.springcloud.mapper.PayInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付Controller
 */
@Slf4j
@RestController
public class PayInfoController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PayInfoMapper payInfoMapper;

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    public PayInfo selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        log.info("我被请求了:{}",port);
        return payInfoMapper.selectPayInfoByOrderNo(orderNo);
    }

    @RequestMapping("/save")
    public String savePayInfo(@RequestBody PayInfo payInfo) {
        log.info("payInfo:{}",payInfo);
        return payInfo.getOrderNo();
    }
 }
