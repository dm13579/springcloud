package com.dm.springcloud.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单支付视图层
 */
@Data
public class OrderAndPayVo implements Serializable {

    private static final long serialVersionUID = 7497657665778290329L;

    private String orderNo;

    private String userName;

    private String productNo;

    private Integer productCount;

    private String payNo;

    private Date payTime;
}
