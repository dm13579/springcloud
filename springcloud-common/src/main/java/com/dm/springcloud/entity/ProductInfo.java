package com.dm.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品信息实例
 */
@Data
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 3277485923804936671L;

    private String productNo;

    private String productName;

    private String productStore;

    private double productPrice;
}
