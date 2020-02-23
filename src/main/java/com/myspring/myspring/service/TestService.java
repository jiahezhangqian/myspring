package com.myspring.myspring.service;


import com.alibaba.fastjson.JSONObject;
import com.myspring.myspring.entity.Test;
import com.myspring.myspring.mapper.TestMapper;
import com.myspring.myspring.utils.ApiCode;
import com.myspring.myspring.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    TestMapper testMapper;

    @Autowired
    Common common;

    @Autowired
    ApiCode apiCode;

    public JSONObject doGetAll(JSONObject param)
    {
        try{
            //必传项
            int page = param.getIntValue("page");
            int everyPageCount = param.getIntValue("everyPageCount");

            int offsetPage = (page - 1) * everyPageCount;

            JSONObject getAllParam = new JSONObject();
            getAllParam.put("offsetPage",offsetPage);
            getAllParam.put("everyPageCount",everyPageCount);
            List<Test> allList =  testMapper.getAll(getAllParam);

            JSONObject result = new JSONObject();
            result.put("page",page);
            result.put("everyPageCount",everyPageCount);
            result.put("list",allList);
            return common.codeReturn(result,apiCode.SUCCESS_CODE,apiCode.SUCCESS_DESC);


        }catch (Exception e)
        {
            e.printStackTrace();
            return common.recordReturn(e);
        }
    }

    public JSONObject doInsert(JSONObject param)
    {
        try{
            //必传项
            String name = param.getString("name");

            JSONObject insertParam = new JSONObject();
            insertParam.put("name",name);
            int insertResult = testMapper.doInsert(insertParam);

            return common.codeReturn(new JSONObject(),apiCode.SUCCESS_CODE,apiCode.SUCCESS_DESC);
        }catch (Exception e)
        {
            e.printStackTrace();
            return common.recordReturn(e);
        }
    }

    public JSONObject doUpdate(JSONObject param)
    {
        try{
            //必传项
            int id = param.getIntValue("id");
            String name = param.getString("name");

            JSONObject updateParam = new JSONObject();
            updateParam.put("id",id);
            updateParam.put("name",name);
            int updateResult = testMapper.doUpdate(updateParam);
            return common.codeReturn(new JSONObject(),apiCode.SUCCESS_CODE,apiCode.SUCCESS_DESC);
        }catch (Exception e)
        {
            e.printStackTrace();
            return common.recordReturn(e);
        }
    }


    public JSONObject doDelete(JSONObject param)
    {
        try{
            //必传项
            int id = param.getIntValue("id");
            JSONObject deleteParam = new JSONObject();
            deleteParam.put("id",id);
            int deleteResult = testMapper.doDelete(deleteParam);
            return common.codeReturn(new JSONObject(),apiCode.SUCCESS_CODE,apiCode.SUCCESS_DESC);

        }catch (Exception e)
        {
            e.printStackTrace();
            return common.recordReturn(e);
        }
    }

}
