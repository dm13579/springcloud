package com.dm.springcloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付信息实例
 */
@Data
public class PayInfo implements Serializable {

    private static final long serialVersionUID = 1030624236777733029L;

    private String payNo;

    private String orderNo;

    private String userName;

    private Date payTime;
}
