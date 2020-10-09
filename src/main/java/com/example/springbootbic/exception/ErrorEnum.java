package com.example.springbootbic.exception;

/**
 * @ClassName: ErrorEnum
 * @Description: 自定义异常信息统一管理
 * @Author: CZJ
 * @Date: 2020/9/30
 */
public enum ErrorEnum {

    /** 请求成功默认返回 */
    SUCCESS(200, "SUCCESS"),
    /** 请求失败默认返回 */
    ERROR(-1, "ERROR"),
    /** 未登录 */
    NOLOG(-99, "未登录")

    /* 公共模块：100.. */


    ;

    private Integer code;
    private String message;

    ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
