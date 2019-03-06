package com.alice.response;


import org.apache.commons.lang3.StringUtils;

public interface ResponseUtil {
    static Response success(String msg, Object result) {
        Response response = new Response();
        response.setCode("0");
        if (StringUtils.isNotBlank(msg)) {
            response.setMsg(msg);
        } else {
            response.setMsg("success");
        }

        if (null != result) {
            response.setResult(result);
        }

        return response;
    }

    static Response success(String msg) {
        return success(msg, (Object)null);
    }

    static Response success(Object result) {
        return success((String)null, result);
    }

    static Response success() {
        return success((String)null, (Object)null);
    }

    static Response fail(String msg, Object result) {
        Response response = new Response();
        response.setCode("1");
        if (StringUtils.isNotBlank(msg)) {
            response.setMsg(msg);
        } else {
            response.setMsg("fail");
        }

        if (null != result) {
            response.setResult(result);
        }

        return response;
    }

    static Response fail(String msg) {
        return fail(msg, (Object)null);
    }

    static Response fail(Object result) {
        return fail((String)null, result);
    }

    static Response fail() {
        return fail((String)null, (Object)null);
    }

    static Response anyone(String code, String msg, Object result) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setResult(result);
        return response;
    }
}
