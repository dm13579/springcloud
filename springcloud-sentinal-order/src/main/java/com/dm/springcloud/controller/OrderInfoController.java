package com.dm.springcloud.controller;

import com.dm.springcloud.entity.OrderInfo;
import com.dm.springcloud.entity.ProductInfo;
import com.dm.springcloud.feignapi.productcenter.ProductCenterFeignApi;
import com.dm.springcloud.mapper.OrderInfoMapper;
import com.dm.springcloud.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class OrderInfoController {

    @Autowired
    private ProductCenterFeignApi productCenterFeignApi;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ProductInfo productInfo = productCenterFeignApi.selectProductInfoById(orderNo);

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

    /**
     * 方法实现说明:模仿  流控模式【关联】  读接口
     * @author:smlz
     * @param orderNo
     * @return:
     * @exception:
     * @date:2019/11/24 22:06
     */
    @RequestMapping("/findById/{orderNo}")
    public Object findById(@PathVariable("orderNo") String orderNo) {
        log.info("orderNo:{}","执行查询操作");
        return orderInfoMapper.selectOrderInfoById(orderNo);
    }

    /**
     * 方法实现说明:模仿流控模式【关联】   写接口(优先)
     * @author:smlz
     * @return:
     * @exception:
     * @date:2019/11/24 22:07
     */
    @RequestMapping("/saveOrder")
    public String saveOrder() {
        log.info("执行保存操作,模仿返回订单ID");
        return UUID.randomUUID().toString();
    }

    @RequestMapping("/findAll")
    public String findAll() throws InterruptedException {
        Thread.sleep(2000);
        //this.orderServiceImpl.common();
        return "findAll";
    }

    @RequestMapping("/findAllByCondtion")
    public String findAllByCondtion() {
        this.orderServiceImpl.common();
        return "findAllByCondition";
    }

}
