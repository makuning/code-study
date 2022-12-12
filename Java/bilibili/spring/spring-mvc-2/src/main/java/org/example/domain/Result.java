package org.example.domain;

import java.util.ArrayList;

/**
 * @author makun
 * @project spring
 * @description Json消息对象
 * @date 2022/12/12 09:34:01
 * version 1.0
 */
public class Result {
    private Integer code;
    private String message;
    private ArrayList<Object> data;

    public Result() {
    }

    public Result(Integer code, String message, ArrayList<Object> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Object> getData() {
        return data;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }
}
