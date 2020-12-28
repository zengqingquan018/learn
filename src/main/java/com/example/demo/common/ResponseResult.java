package com.example.demo.common;

import com.example.demo.enums.ResponseEnums;

public class ResponseResult<T> {

    private Integer code;
    private String msg;
    private T result;

    public ResponseResult() {

    }


    public static <T> ResponseResult<T> success(T result) {
        return new ResponseResult<>(ResponseEnums.CODE_200, result);
    }

    public ResponseResult(ResponseEnums responseEnums, T result) {
        this.code = responseEnums.getCode();
        this.msg = responseEnums.getMessage();
        this.result = result;
    }


    public ResponseResult(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResponseResult(ResponseEnums responseEnums) {
        this.code = responseEnums.getCode();
        this.msg = responseEnums.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
