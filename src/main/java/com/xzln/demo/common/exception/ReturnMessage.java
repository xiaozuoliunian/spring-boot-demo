package com.xzln.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnMessage<T> {

    /**
     *  错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回具体内容
     */
    private T date;

    public ReturnMessage(Integer code, String message, T date) {
        super();
        this.code = code;
        this.message = message;
        this.date = date;
    }
}
