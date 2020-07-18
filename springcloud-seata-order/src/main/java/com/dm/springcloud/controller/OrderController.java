package com.dm.springcloud.controller;


import com.dm.springcloud.entity.OrderInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.feignapi.productcenter.AccountCenterFeignApi;
import com.dm.springcloud.feignapi.productcenter.ProductCenterFeignApi;
import com.dm.springcloud.mapper.OrderInfoMapper;
import com.dm.springcloud.vo.Result;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;


@RestController
@Slf4j
public class OrderController {

    @Autowired
    private AccountCenterFeignApi accountCenterFeignApi;

    @Autowired
    private ProductCenterFeignApi productCenterFeignApi;

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    /**
     * 创建订单
     */
    @GetMapping("/create")
    public Result create(OrderInfo order) {
        log.info("当前 XID: {}", RootContext.getXID());
        ProductInfo productInfo = productCenterFeignApi.selectProductInfoById(order.getProductNo());
        log.info("下单开始,用户:{},商品:{},数量:{},金额:{}", order.getUserName(), order.getProductNo(), order.getProductCount(), productInfo.getProductPrice());
        //创建订单
        order.setCreateDt(new Date());
        order.setStatus(0);
        orderInfoMapper.saveOrder(order);
        log.info("保存订单{}", order);

        //远程调用库存服务扣减库存
        log.info("扣减库存开始");
        productCenterFeignApi.reduceCount(order.getProductNo(), order.getProductCount());
        log.info("扣减库存结束");

        /* System.out.println(1/0);*/

        //远程调用账户服务扣减余额
        log.info("扣减余额开始");
        accountCenterFeignApi.reduceBalance(order.getUserId(), new BigDecimal(productInfo.getProductPrice()));
        log.info("扣减余额结束");

        //修改订单状态为已完成
        log.info("修改订单状态开始");
        orderInfoMapper.updateOrderStatusById(order.getOrderNo(),1);
        log.info("修改订单状态结束");

        log.info("下单结束");

        return Result.success("订单ID:"+order.getOrderNo());
    }
}

