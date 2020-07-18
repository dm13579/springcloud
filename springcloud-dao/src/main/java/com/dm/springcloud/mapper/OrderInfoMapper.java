package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

/**
 * 订单Mapper
 */
public interface OrderInfoMapper {

    /**
     * 商品编号查询商品
     *
     * @param orderNo
     * @return
     */
    OrderInfo selectOrderInfoById(String orderNo);

    int saveOrder(OrderInfo order);

    int updateOrderStatusById(@Param("orderId") String orderNo, @Param("status") Integer orderStatus);

}
