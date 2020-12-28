package com.example.demo.exception;

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

    public Integer getCode() {
        return code;
    }

    public void fail(String message) {

    }
}
