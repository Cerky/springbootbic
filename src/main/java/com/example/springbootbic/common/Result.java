package com.example.springbootbic.common;

import com.example.springbootbic.exception.ErrorEnum;

/**
 * @ClassName: Result
 * @Description: 封装接口响应数据，用于统一接口返回数据格式
 * @Author: CZJ
 * @Date: 2020/9/28
 */
public class Result {

    private int code;           // 状态码
    private String message;     // 描述
    private Object data;        // 封装返回数据

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ErrorEnum errorEnum, Object data) {
        this.code = errorEnum.getCode();
        this.message = errorEnum.getMessage();
        this.data = data;
    }

    public static Result success() {
        return new Result(ErrorEnum.SUCCESS, null);
    }

    public static Result success(Object data) {
        return new Result(ErrorEnum.SUCCESS, data);
    }

    public static Result success(ErrorEnum errorEnum, Object data) {
        return new Result(errorEnum, data);
    }

    public static Result failure() {
        return new Result(ErrorEnum.ERROR, null);
    }

    public static Result failure(String message) {
        return new Result(ErrorEnum.ERROR.getCode(), message, null);
    }

    public static Result failure(int code, String message) {
        return new Result(code, message, null);
    }

    public static Result failure(ErrorEnum errorEnum) {
        return new Result(errorEnum, null);
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
