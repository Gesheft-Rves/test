package com.rves.test.entity.response;

public class StartResponse {
    private String msg;

    public StartResponse() {
    }

    public StartResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "StartResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
