package com.alice.response;

import java.io.Serializable;

public class Response implements Serializable {
    //private static final long serialVersionUID = 5676419694423869147L;
    private String code;
    private String msg;
    private Object result;

    public Response() {
    }

    public String getCode() {
        return this.code;
    }

    public Response setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getResult() {
        return this.result;
    }

    public Response setResult(Object result) {
        this.result = result;
        return this;
    }
}