package com.dm.springcloud.mapper;

import com.dm.springcloud.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;

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

    Integer reduceCount(@Param("productNo") String productNo, @Param("amount") Integer amount);

    Integer selectCountById(@Param("productNo") String productNo);

}
