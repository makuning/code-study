package org.example.controller;

import org.example.domain.Result;
import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author makun
 * @project spring
 * @description 全局异常处理
 * @date 2022/12/12 09:30:06
 * version 1.0
 */

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException exception) {
        System.out.println("系统异常你好");
        // 记录日志
        // 发送消息给运维
        // 发送邮件给运维人员
        return new Result(500, "服务器繁忙，请稍后再试", null);
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException exception) {
        System.out.println("业务异常你好");
        return new Result(500, exception.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        System.out.println("未知异常你好");
        return new Result(5999, exception.getMessage(), null);
    }
}
