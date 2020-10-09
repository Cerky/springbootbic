package com.example.springbootbic.exception;

/**
 * @ClassName : CustomException
 * @Description : 自定义运行时异常
 * @Author : CZJ
 * @Date: 2020/9/2
 */
public class CustomException extends RuntimeException {

    private Integer code;       // 编码

    public CustomException(String msg) {
        super(msg);
        this.code = ErrorEnum.ERROR.getCode();
    }

    public CustomException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
