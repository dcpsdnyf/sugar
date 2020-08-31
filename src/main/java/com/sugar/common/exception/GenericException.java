package com.sugar.common.exception;

import java.io.Serializable;

public class GenericException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    String errorCode;
    String errorMessage;
    Exception errOri;
    private static final String GenericErrorMsg = "系统级异常[系统运行或数据异常]";

    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String errorCode, String message) {
        super("errCode=" + errorCode + ",message=" + message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public GenericException(Exception oriEx) {
        super("errCode=999999,message=系统级异常[系统运行或数据异常]");
        this.errorCode = "999999";
        this.errorMessage = "系统级异常[系统运行或数据异常]";
    }

    public GenericException(String message, Exception oriEx) {
        super(message, oriEx);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getErrOri() {
        return this.errOri;
    }

    public void setErrOri(Exception errOri) {
        this.errOri = errOri;
    }
}
