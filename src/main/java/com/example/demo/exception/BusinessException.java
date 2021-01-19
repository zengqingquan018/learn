package com.example.demo.exception;

import com.example.demo.enums.ResponseEnums;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 10:04
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
        code = ResponseEnums.CODE_405.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void fail(String message) {

    }
}
