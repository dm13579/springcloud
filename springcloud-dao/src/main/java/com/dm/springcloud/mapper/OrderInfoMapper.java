package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.OrderInfo;

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
}
