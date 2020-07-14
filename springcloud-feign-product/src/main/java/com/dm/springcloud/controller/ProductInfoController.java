package com.dm.springcloud.controller;

import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品Controller
 */
@RestController
@Slf4j
public class ProductInfoController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo) throws InterruptedException {
        log.info("我被调用了：" + port);
        //Thread.sleep(3000);
        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return productInfo;
    }

    @RequestMapping("/getToken4Header")
    public String getToken4Header(@RequestHeader("Token") String token) {
        log.info("token:{}", token);
        return token;
    }
}
