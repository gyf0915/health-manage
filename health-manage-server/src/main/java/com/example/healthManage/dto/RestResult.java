package com.example.healthManage.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 3161850176095433538L;

    protected int code;
    protected String message;

    protected T data;
    protected String flag;
    protected String errorCode;
    protected String errorInfo;

    public RestResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RestResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public RestResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean ok() {
        return this.code == 0 || this.code == 200;
    }

    public String toString() {
        return "RestResult{code=" + this.code + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
    }

    public static RestResult T() {
        return new RestResult(ResultCode.CODE200);
    }

    public RestResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static RestResult T(Object data) {
        RestResult restResult = T();
        restResult.setData(data);
        return restResult;
    }

    public static RestResult F() {
        return new RestResult(ResultCode.CODE500);
    }
}
