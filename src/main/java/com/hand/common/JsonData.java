package com.hand.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class JsonData {

    private boolean ret;

    private String msg;

    Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData success(Object obj, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = obj;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object obj) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = obj;
        return  jsonData;
    }

    public static JsonData success(String msg) {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("msg", msg);
        result.put("data", data );
        result.put("ret", ret);
        return result;
    }
}
