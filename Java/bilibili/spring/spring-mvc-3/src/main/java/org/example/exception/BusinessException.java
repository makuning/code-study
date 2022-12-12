package org.example.exception;

/**
 * @author makun
 * @project spring
 * @description 业务异常
 * @date 2022/12/12 15:47:56
 * version 1.0
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException() {
    }

    public BusinessException(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
