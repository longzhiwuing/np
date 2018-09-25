package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.entity.StHospitcalKeyIndicatorM;
import com.cecdat.np.mapper.DataResourceBaseInfoMapper;
import com.cecdat.np.mapper.StHospitcalKeyIndicatorMMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 记录各家医院每月每个系统的数据量 服务实现类
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Service
public class StHospitcalKeyIndicatorMService extends ServiceImpl<StHospitcalKeyIndicatorMMapper, StHospitcalKeyIndicatorM>{

    @Autowired
    private StHospitcalKeyIndicatorMMapper stHospitcalKeyIndicatorMMapper;
    @Autowired
    private DataResourceBaseInfoMapper resourceBaseInfoMapper;


    public List<Map<String, Object>> getSystemData(){
        return stHospitcalKeyIndicatorMMapper.getSystemData();
    }

    public List<Map<String, Object>> getCollectionData(){
        return stHospitcalKeyIndicatorMMapper.getCollectionData();
    }

    public List<Map<String, Object>> getControlData(){
        return stHospitcalKeyIndicatorMMapper.getControlData();
    }

    public JSONObject selectSysNameAndCount() {
        JSONObject jsonObject = new JSONObject();
        JSONArray series = new JSONArray();
        JSONArray legend = new JSONArray();
        List<HashMap> hashMapList = stHospitcalKeyIndicatorMMapper.selectSysNameAndCount();
        for(HashMap hashMap: hashMapList) {
            JSONObject object = new JSONObject();
            String keyHospitalName = "sysname";
            String keyHospitalDataCount = "syscount";
            if (hashMap.containsKey(keyHospitalName) && hashMap.containsKey(keyHospitalDataCount)) {
                Object name = hashMap.get(keyHospitalName);
                Object value = hashMap.get(keyHospitalDataCount);
                object.put("value",value);
                legend.add(name);
                object.put("name",name);
            }
            series.add(object);
        }
        jsonObject.put("series",series);
        jsonObject.put("legend",legend);
        return jsonObject;
    }


    public JSONObject getResourceData() {
        JSONObject jsonObject = new JSONObject();
        HashMap hashMap = resourceBaseInfoMapper.getResourceData();
        if(hashMap.containsKey("dname")){
            jsonObject.put("dName",hashMap.get("dname"));
        }
        if(hashMap.containsKey("mdnum")){
            jsonObject.put("mdNum",hashMap.get("mdnum"));
        }
        if(hashMap.containsKey("sysname")){
            jsonObject.put("sysName",hashMap.get("sysname"));
        }
        if(hashMap.containsKey("dcount")){
            jsonObject.put("dCount",hashMap.get("dcount"));
        }
        return  jsonObject;
    }

}
