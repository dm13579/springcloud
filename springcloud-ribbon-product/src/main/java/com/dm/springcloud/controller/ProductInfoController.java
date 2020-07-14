package com.dm.springcloud.controller;

import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品Controller
 */
@Slf4j
@RestController
public class ProductInfoController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public Object selectProductInfoById(@PathVariable("productNo") String productNo) {
        log.info("我被请求了:{}",port);
        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return productInfo;
    }
 }
