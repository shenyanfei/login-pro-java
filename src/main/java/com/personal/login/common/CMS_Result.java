package com.personal.login.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 空谷幽兰 on 2017/5/15.
 */
public class CMS_Result {


    private static final long serialVersionUID = 1L;
    private String success;
    private Map<String, Object> data = new HashMap<String, Object>();

    public CMS_Result() {
    }

    public CMS_Result(String success, Map<String, Object> data) {
        this.success = success;
        this.data = data;
    }
    public CMS_Result(List<Object> list) {
        this.success = "true";
        data.put("count", list.size());
        data.put("list", list);
    }

    public CMS_Result(String error, String msg) {
        this.success = "false";
        data.put("error", error);
        data.put("msg", msg);
    }

    public CMS_Result(String status) {
        this.success = status;
    }

    public static CMS_Result ok() {
        return new CMS_Result("true");
    }
    public static CMS_Result ok(List<Object> list) {
        return new CMS_Result(list);
    }

    public static CMS_Result bulid(String error, String msg) {
        return new CMS_Result(error, msg);
    }

    public static CMS_Result bulid(String success, Map<String, Object> data) {
        return new CMS_Result(success, data);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }




}
