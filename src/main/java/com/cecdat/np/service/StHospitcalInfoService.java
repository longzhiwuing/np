package com.cecdat.np.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.entity.StHospitcalInfo;
import com.cecdat.np.mapper.StHospitcalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 记录医院的基本信息 服务实现类
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Service
public class StHospitcalInfoService extends ServiceImpl<StHospitcalInfoMapper, StHospitcalInfo>{

    @Autowired
    private StHospitcalInfoMapper stHospitcalInfoMapper;

    public int getTotalHospitalData(){
        return stHospitcalInfoMapper.getTotalHospitalData();
    }

    public int getTopThreeHospitalData(){
        return stHospitcalInfoMapper.getTotalHospitalData();
    }


    public JSONObject selectNameAndCount() {
        JSONObject jsonObject = new JSONObject();
        JSONArray series = new JSONArray();
        JSONArray legend = new JSONArray();
        List<HashMap> hashMapList = stHospitcalInfoMapper.selectNameAndCount();
        for(HashMap hashMap: hashMapList) {
            JSONObject object = new JSONObject();
            String keyHospitalName = "hospital_name";
            String keyHospitalDataCount = "hospital_data_count";
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

}
