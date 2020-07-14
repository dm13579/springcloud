package com.dm.springcloud.controller;

import com.dm.springcloud.entity.OrderInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.OrderInfoMapper;
import com.dm.springcloud.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单Controller
 */
@RestController
public class OrderInfoController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/selectOredrInfoById/{orderNo}")
    public Object selectOredrInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);

        if (null == orderInfo) {
            return "根据orderNo:" + orderNo + "查询没有该订单";
        }

        ResponseEntity<ProductInfo> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity("http://product-center/selectProductInfoById/" + orderInfo.getProductNo(), ProductInfo.class);
        } catch (Exception e) {
            System.out.println("请求商品服务异常:{}" + e.getStackTrace());
        }

        ProductInfo productInfo = responseEntity.getBody();

        if (productInfo == null) {
            return "没有对应的商品";
        }

        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }

}
