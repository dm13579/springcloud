package com.dm.springcloud.exceptionhandler;

import com.dm.springcloud.vo.OrderVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设值全局异常
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseBody
    public Object dealBizException() {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo("-1");
        orderVo.setUserName("容错用户");
        return orderVo;
    }
}
