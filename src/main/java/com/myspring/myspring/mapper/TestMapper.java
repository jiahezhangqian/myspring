package com.myspring.myspring.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myspring.myspring.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<Test> getAll(JSONObject param);
    int doInsert(JSONObject insertParam);
    int doUpdate(JSONObject updateParam);
    int doDelete(JSONObject deleteParam);
}
