package com.myspring.myspring.controllers;

import com.alibaba.fastjson.JSONObject;
import com.myspring.myspring.service.TestService;
import com.myspring.myspring.utils.ApiCode;
import com.myspring.myspring.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello()
    {
        return "Access Dency";
    }
    @Autowired
    Common common;
    @Autowired
    TestService testService;
    @Autowired
    ApiCode apiCode;

    @RequestMapping(value = "/hello/getall",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JSONObject getAll(@RequestBody JSONObject jsonParam)
    {
        //System.out.println(jsonParam.toJSONString());
        //todo 进行相关参数验证
        //todo 进行具体的业务
        JSONObject doGetAllResult = testService.doGetAll(jsonParam);
        if(apiCode.SUCCESS_CODE == doGetAllResult.getIntValue("code"))
        {
            return common.codeReturn(doGetAllResult.get("data"),doGetAllResult.getIntValue("code"),doGetAllResult.getString("desc"));
        }else {
            return common.codeReturn(new JSONObject(),apiCode.ERROR_CODE,apiCode.ERROR_DESC);
        }
    }


    @RequestMapping(value = "/hello/insert",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JSONObject insert(@RequestBody JSONObject jsonParam)
    {
        //System.out.println(jsonParam.toJSONString());
        //todo 进行相关参数验证
        //todo 进行具体的业务
        JSONObject doInsertResult =  testService.doInsert(jsonParam);
        if(apiCode.SUCCESS_CODE == doInsertResult.getIntValue("code"))
        {
            return common.codeReturn(doInsertResult.get("data"),doInsertResult.getIntValue("code"),doInsertResult.getString("desc"));
        }else {
            return common.codeReturn(new JSONObject(),apiCode.ERROR_CODE,apiCode.ERROR_DESC);
        }
    }

    @RequestMapping(value = "/hello/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JSONObject update(@RequestBody JSONObject jsonParam)
    {
        //System.out.println(jsonParam.toJSONString());
        //todo 进行相关参数验证
        //todo 进行具体的业务
        JSONObject doUpdateResult =  testService.doUpdate(jsonParam);
        if(apiCode.SUCCESS_CODE == doUpdateResult.getIntValue("code"))
        {
            return common.codeReturn(doUpdateResult.get("data"),doUpdateResult.getIntValue("code"),doUpdateResult.getString("desc"));
        }else {
            return common.codeReturn(new JSONObject(),apiCode.ERROR_CODE,apiCode.ERROR_DESC);
        }
    }

    @RequestMapping(value = "/hello/delete",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JSONObject delete(@RequestBody JSONObject jsonParam)
    {
        //System.out.println(jsonParam.toJSONString());
        //todo 进行相关参数验证
        //todo 进行具体的业务
        JSONObject doDeleteResult = testService.doDelete(jsonParam);
        if(apiCode.SUCCESS_CODE == doDeleteResult.getIntValue("code"))
        {
            return common.codeReturn(doDeleteResult.get("data"),doDeleteResult.getIntValue("code"),doDeleteResult.getString("desc"));
        }else {
            return common.codeReturn(new JSONObject(),apiCode.ERROR_CODE,apiCode.ERROR_DESC);
        }
    }
}
