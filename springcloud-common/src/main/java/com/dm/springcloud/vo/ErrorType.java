package com.dm.springcloud.vo;

public interface ErrorType {

    /**
     * 返回code
     *
     * @return
     */
    String getStatus();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMsg();
}
