package com.sugar.util;

public class ResultMessage {
    private String resultMassage;

    private Object data;

    private String code;

    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getResultMassage() {
        return resultMassage;
    }

    public void setResultMassage(String resultMassage) {
        this.resultMassage = resultMassage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
