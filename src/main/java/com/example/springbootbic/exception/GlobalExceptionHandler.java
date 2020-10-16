package com.example.springbootbic.exception;

import com.example.springbootbic.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理
 * @Author: CZJ
 * @Date: 2020/9/30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义异常处理
     * @param cex           异常
     * @return              错误信息
     */
    @ExceptionHandler(value = CustomException.class)
    public Result customExceptionHandler(CustomException cex) {
        return Result.failure(cex.getCode(), cex.getMessage());
    }

    /**
     * 处理未定义的其他异常信息
     * @param ex            异常
     * @return              异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception ex) {
        logger.error(ex.getMessage(), ex);      // 异常记录日志
        return Result.failure(ErrorEnum.SERVER_ERROR);  // 不能直接使用异常信息（返回值需要屏蔽异常信息，特别是sql异常信息）
    }

}
