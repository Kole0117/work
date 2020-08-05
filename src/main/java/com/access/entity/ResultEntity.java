package com.access.entity;

import java.util.List;

public class ResultEntity {

    private String resultCode;
    private String resuleMsg;
    private List<?> Data;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResuleMsg() {
        return resuleMsg;
    }

    public void setResuleMsg(String resuleMsg) {
        this.resuleMsg = resuleMsg;
    }

    public List<?> getData() {
        return Data;
    }

    public void setData(List<?> data) {
        Data = data;
    }
}
