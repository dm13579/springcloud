package com.dm.springcloud.vo;

import lombok.Getter;

/**
 * 错误类型
 */
@Getter
public enum SystemErrorType implements ErrorType {

    /**
     * 无权访问,请求头为空
     */
    UNAUTHORIZED_HEADER_IS_EMPTY("004011","无权访问,请求头为空"),

    /**
     * token过期
     */
    TOKEN_TIMEOUT("004012","token过期"),

    /**
     * 无效token
     */
    INVALID_TOKEN("004013", "无效token"),

    /**
     * 无权访问
     */
    FORBIDDEN("004013","无权访问"),

    /**
     * 网关超时
     */
    GATEWAY_CONNECT_TIME_OUT("000504", "网关超时"),

    /**
     * 网关异常
     */
    GATEWAY_ERROR("000501", "网关异常"),

    /**
     * 错误网关
     */
    BAD_GATEWAY("000502","错误网关"),

    /**
     * 服务未找到
     */
    GATEWAY_NOT_FOUND_SERVICE("0000001", "服务未找到"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR("000002", "系统异常"),

    /**
     * 系统繁忙,请稍候再试
     */
    SYSTEM_BUSY("000003", "系统繁忙,请稍候再试"),

    /**
     * 处理成功
     */
    SUCCESS("888888","处理成功"),

    /**
     * 没有登陆
     */
    NOT_LOGIN("-1","没有登陆"),

    /**
     * 登陆失败,用户名密码错误
     */
    LOGIN_FAIL("000004","登陆失败,用户名密码错误"),

    /**
     * 登陆成功
     */
    LOGIN_SUCCESS("000005","登陆成功"),

    /**
     * 退出成功
     */
    LOGOUT_SUCCESS("000006","退出成功"),

    /**
     * 刷新令牌过期
     */
    REFRESH_TOKEN_EXPIRE("000007","刷新令牌过期"),

    /**
     * 认证服务器获取Token异常
     */
    GET_TOKEN_KEY_ERROR("000008","认证服务器获取Token异常"),

    /**
     * 生成公钥异常
     */
    GEN_PUBLIC_KEY_ERROR("000009","生成公钥异常");

    /**
     * 错误类型码
     */
    private String status;
    /**
     * 错误类型描述信息
     */
    private String msg;

    SystemErrorType(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
