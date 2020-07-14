package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.ProductInfo;

/**
 * 商品Mapper
 */
public interface ProductInfoMapper {

    /**
     * 通过id查询商品
     *
     * @param productNo
     * @return
     */
    ProductInfo selectProductInfoById(String productNo);
}
