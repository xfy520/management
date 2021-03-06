package com.school.management.domain;

import lombok.Data;

import java.util.Arrays;

@Data
public class Log {
    private String userId;
    private String userName;
    private int perms;
    private String url;
    private String classMethod;
    private Object[] args;
    private Object returnValue;
    private String methodName;

    public Log(String userId, String userName, int perms, String url, String classMethod, Object[] args, Object returnValue, String methodName) {
        this.userId = userId;
        this.userName = userName;
        this.perms = perms;
        this.url = url;
        this.classMethod = classMethod;
        this.args = args;
        this.returnValue = returnValue;
        this.methodName = methodName;
    }
}