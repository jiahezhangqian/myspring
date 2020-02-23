package com.myspring.myspring.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Common {

    @Autowired
    ApiCode apiCode;

    public  JSONObject codeReturn(Object data,int code,String desc)
    {
        JSONObject result = new JSONObject();
        result.put("code",code);
        result.put("desc",desc);
        if(null != data) {
            result.put("data",data);
        } else {
            result.put("data",new JSONObject());
        }
        doSms(code);
        return result;
    }

    public JSONObject codeReturn(Object data)
    {
        JSONObject result = new JSONObject();
        result.put("code",apiCode.ERROR_CODE);
        result.put("desc",apiCode.ERROR_DESC);
        if(null != data) {
            result.put("data",data);
        } else {
            result.put("data",new JSONObject());
        }
        return result;
    }

    public JSONObject recordReturn(Exception exception)
    {
        JSONObject result = new JSONObject();
        result.put("code",apiCode.ERROR_CODE);
        result.put("desc",exception.getMessage());
        result.put("data",new JSONObject());
        return result;
    }


    private void doSms(int code)
    {
        try {
            boolean existCode = apiCode.isExistCode(code);
            if (!existCode) {
                //todo 干些啥，比如钉钉通知
                System.out.println("进行钉钉通知操作");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
