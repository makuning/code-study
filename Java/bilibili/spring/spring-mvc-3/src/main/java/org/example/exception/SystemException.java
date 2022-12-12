package org.example.exception;

/**
 * @author makun
 * @project spring
 * @description 系统异常
 * @date 2022/12/12 15:47:22
 * version 1.0
 */
public class SystemException extends RuntimeException {
    private Integer code;

    public SystemException() {
    }

    public SystemException(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code, String message) {
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
