package com.example.healthManage.dto;

public enum ResultCode {
    CODE200(200, "Success"),
    CODE401(401, "未通过身份验证"),
    CODE403(403, "不具有访问资源的权限"),
    CODE404(404, "请求的资源不存在"),
    CODE405(405, "不允许使用该请求方式"),
    CODE408(408, "请求超时"),
    CODE413(413, "请求体过大"),
    CODE414(414, "请求地址过长"),
    CODE415(415, "媒体类型不支持"),
    CODE429(429, "请求次数超过限额"),
    CODE431(431, "请求头过大"),
    CODE500(500, "服务器遇到未知问题"),
    CODE503(503, "服务器正在维护"),
    CODE504(504, "网关超时");

    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
