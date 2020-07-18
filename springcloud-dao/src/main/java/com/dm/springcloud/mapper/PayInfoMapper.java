package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.PayInfo;

/**
 * 支付Mapper
 */
public interface PayInfoMapper {

    /**
     * 商品编号查询支付信息
     *
     * @param orderNo
     * @return
     */
    PayInfo selectPayInfoByOrderNo(String orderNo);

}
