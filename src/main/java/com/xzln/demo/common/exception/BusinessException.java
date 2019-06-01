package com.xzln.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException{

    private Integer code;

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
