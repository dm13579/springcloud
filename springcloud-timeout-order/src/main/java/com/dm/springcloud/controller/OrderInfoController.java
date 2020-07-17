package com.dm.springcloud.controller;

import com.dm.springcloud.entity.OrderInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.OrderInfoMapper;
import com.dm.springcloud.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单Controller
 */
@RestController
public class OrderInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public static final String uri = "http://localhost:8081/selectProductInfoById/";

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ProductInfo productInfo=null;
        try{
            ResponseEntity<ProductInfo> responseEntity= restTemplate.getForEntity(uri+orderInfo.getProductNo(), ProductInfo.class);
            productInfo = responseEntity.getBody();
            int i = 1/0;
        }catch (Exception e) {
            throw new RuntimeException("调用超时");
        }
        if(productInfo == null) {
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
