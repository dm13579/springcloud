package com.dm.springcloud.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单视图层
 */
@Data
public class OrderVo implements Serializable {

    private static final long serialVersionUID = -8108914610899141073L;

    private String orderNo;

    private String userName;

    private String productName;

    private Integer productNum;

}
