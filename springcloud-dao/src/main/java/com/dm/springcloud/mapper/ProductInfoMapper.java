package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.ProductInfo;

/**
 * Created by smlz on 2019/11/17.
 */
public interface ProductInfoMapper {

    ProductInfo selectProductInfoById(String productNo);
}
