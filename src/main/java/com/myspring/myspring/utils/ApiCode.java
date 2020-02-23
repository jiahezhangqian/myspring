package com.myspring.myspring.utils;


import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public final class ApiCode {
    public final int SUCCESS_CODE = 10000;
    public final String SUCCESS_DESC = "success";

    public final int ERROR_CODE = 20000;
    public final String ERROR_DESC = "error";

    public final boolean isExistCode(int code) throws IllegalAccessException {
        ApiCode apiCode = new ApiCode();
        Class apiCodeClass = apiCode.getClass();
        Field[] fields = apiCodeClass.getDeclaredFields();
        int len = fields.length;
        for (int i = 0; i < len ; i ++)
        {
            Field field = fields[i];
            Object type = field.getType();
            if(!int.class.equals(type)) {
                continue;
            }
            int codeValue = field.getInt(apiCode);
            if(codeValue == code) {
                return true;
            }
        }
        return false;
    }

}
