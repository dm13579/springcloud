package com.dm.springcloud.util;

/**
 * 类的描述:sentinel 错误枚举类
 */
public enum ErrorEnum {

    FLOW_RULE_ERR(-1, "触发流控"),

    HOT_PARAM_FLOW_RULE_ERR(-2, "参数流控了"),

    AUTH_RULE_ERR(-3, "权限校验不通过"),

    SYS_RULE_ERR(-4, "系统负载不满足"),

    DEGRADE_RULE_ERR(-5, "降级规则触发");

    private Integer errCode;

    private String errMsg;

    ErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
