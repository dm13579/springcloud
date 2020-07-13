package com.dm.springcloud.controller;

import com.dm.springcloud.entity.OrderInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.mapper.OrderInfoMapper;
import com.dm.springcloud.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
  *                  ,;,,;
  *                ,;;'(    
  *      __      ,;;' ' \   
  *   /'  '\'~~'~' \ /'\.)  
  * ,;(      )    /  |.     
  *,;' \    /-.,,(   ) \    
  *     ) /       ) / )|    
  *     ||        ||  \)     
  *    (_\       (_\
  *@ClassName OrderInfoController
  *@Description TODO
  *@Author dm
  *@Date 2020/3/4 21:11
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
@RestController
public class OrderInfoController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/selectOredrInfoById/{orderNo}")
    public Object selectOredrInfoById(@PathVariable("orderNo")String orderNo){

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(orderInfo == null){
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("product-center");
        if(instances == null || instances.isEmpty()){
            return "用户微服务没有对应的实例可用";
        }

        String url = instances.get(0).getUri().toString();

        ResponseEntity<ProductInfo> forEntity = restTemplate.getForEntity(url + "/selectProductInfoById/" + orderInfo.getOrderNo(), ProductInfo.class);
        ProductInfo productInfo = forEntity.getBody();
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

    @GetMapping("getServiceList")
    public List<ServiceInstance> getServiceList(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("order-center");
        return serviceInstanceList;
    }

}
