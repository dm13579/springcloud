package com.dm.springcloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息实例
 */
@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 4418905059140775741L;

    private String orderNo;

    private String userName;

    private Date createDt;

    private String productNo;

    private Integer productCount;

    private Integer userId;

    /**
     * 状态 0下单 1完成
     */
    private Integer status;
}
