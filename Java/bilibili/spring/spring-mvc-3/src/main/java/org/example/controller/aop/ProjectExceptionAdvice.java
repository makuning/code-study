package org.example.controller.aop;

import org.example.domain.JsonResult;
import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author makun
 * @project spring
 * @description 异常处理
 * @date 2022/12/12 15:35:54
 * version 1.0
 */

// 让springmvc将此类处理为异常通知，并将处理方法的返回值作为响应体
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 处理系统异常
    @ExceptionHandler(SystemException.class)
    public JsonResult businessException(SystemException systemException) {
        // 记录日志

        // 给运维发送邮件（消息）

        return new JsonResult(500, "系统繁忙，请稍后再试", null);
    }

    // 处理业务异常
    @ExceptionHandler(BusinessException.class)
    public JsonResult businessException(BusinessException businessException) {
        return new JsonResult(400, "请不要使用违规操作", null);
    }

    // 处理未知异常
    @ExceptionHandler(Exception.class)
    public JsonResult exceptionHandler(Exception exception) {
        // 记录日志

        // 给程序员发送邮件（消息）

        // 返回一个对象消息
        return new JsonResult(500, exception.getMessage(), null);
    }
}
