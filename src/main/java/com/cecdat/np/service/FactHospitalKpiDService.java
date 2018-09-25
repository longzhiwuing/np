package com.cecdat.np.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cecdat.np.entity.DimOrgDict;
import com.cecdat.np.entity.FactHospitalKpiD;
import com.cecdat.np.mapper.DimOrgDictMapper;
import com.cecdat.np.mapper.FactHospitalKpiDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 医院指标汇总日表 服务实现类
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-25
 */
@Service
public class FactHospitalKpiDService extends ServiceImpl<FactHospitalKpiDMapper, FactHospitalKpiD> {

    @Autowired
    FactHospitalKpiDMapper hospitalKpiDMapper;

    @Autowired
    private DimOrgDictMapper orgDictMapper;

    public JSONObject HospitalCodeForCharts() {
        JSONObject jsonObject = new JSONObject();
        JSONArray xAxis = new JSONArray();
        JSONObject series = new JSONObject();
        JSONArray arrayRegisterNum = new JSONArray();
        JSONArray arrEmergencyNum = new JSONArray();
        List<HashMap> hashMapList = hospitalKpiDMapper.countByHospitalCodeForCharts();
        for (HashMap hashMap : hashMapList) {
            String keyDispRegisterNum = "dispRegisterNum";
            String keydispEmergencyNum = "dispEmergencyNum";
            String keyorgCode = "orgCode";
            if (hashMap.containsKey(keyorgCode)) {
                Object orgCode = hashMap.get(keyorgCode);
                DimOrgDict orgDict = orgDictMapper.selectByOrgCode(orgCode.toString());
                if (orgDict != null) {
                    xAxis.add(orgDict.getOrgName());
                    if (hashMap.containsKey(keyDispRegisterNum)) {
                        Object dispRegisterNum = hashMap.get(keyDispRegisterNum);
                        arrayRegisterNum.add(dispRegisterNum);
                    }
                    if (hashMap.containsKey(keydispEmergencyNum)) {
                        Object dispEmergencyNum = hashMap.get(keydispEmergencyNum);
                        arrEmergencyNum.add(dispEmergencyNum);
                    }
                }
            }


        }
        series.put("contractValue",arrayRegisterNum);
        series.put("reimbursementValue",arrEmergencyNum);
        jsonObject.put("xAxis", xAxis);
        jsonObject.put("series", series);
        return jsonObject;
    }

}
