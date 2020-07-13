package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.PayInfo;

/**
 * Created by smlz on 2019/11/20.
 */
public interface PayInfoMapper {

    PayInfo selectPayInfoByOrderNo(String orderNo);
}
