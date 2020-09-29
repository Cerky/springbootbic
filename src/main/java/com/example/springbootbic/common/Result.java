package com.example.springbootbic.common;

/**
 * @ClassName: Result
 * @Description: 封装接口响应数据，用于统一接口返回数据格式
 * @Author: CZJ
 * @Date: 2020/9/28
 */
public class Result {

    private static final int CODE_SUCCESS = 200;            // 请求成功默认状态码
    private static final int CODE_ERROR = -1;               // 请求失败默认状态码
    private static final String MESSAGE_SUCCESS = "SUCCESS";    // 请求成功默认描述
    private static final String MESSAGE_ERROR = "ERROR";        // 请求失败默认描述

    private int code;           // 状态码
    private String message;     // 描述
    private Object data;        // 封装返回数据

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(CODE_SUCCESS, MESSAGE_SUCCESS, null);
    }

    public static Result success(Object data) {
        return new Result(CODE_SUCCESS, MESSAGE_SUCCESS, data);
    }

    public static Result success(int code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result failure() {
        return new Result(CODE_ERROR, MESSAGE_ERROR, null);
    }

    public static Result failure(String message) {
        return new Result(CODE_ERROR, message, null);
    }

    public static Result failure(int code, String message) {
        return new Result(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
