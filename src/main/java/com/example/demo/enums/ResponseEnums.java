package com.example.demo.enums;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 10:19
 */
public enum ResponseEnums {
    /**
     * 返回值
     */
    CODE_200(200, "成功"),
    CODE_403(403, "用户未登录"),
    CODE_99999(99999, "未知异常"),

    CODE_405(405, "校验失败"),
    CODE_600(600, "用户名或密码不能为空");
    private final Integer code;

    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
