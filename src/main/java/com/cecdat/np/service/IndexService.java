package com.cecdat.np.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/26
 * Time: 10:12
 */
@Service
@Slf4j
public class IndexService {

    @Autowired
    StHospitcalInfoService stHospitcalInfoService;

    @Autowired
    StHospitcalKeyIndicatorMService stHospitcalKeyIndicatorMService;

    @Autowired
    StEcologicalDatasetService stEcologicalDatasetService;

//    @CheckJsonApi
    public JSONObject getIndexData() {
        JSONObject dataObj = new JSONObject();
        int hosCount = stHospitcalInfoService.selectCount(new EntityWrapper<>());

        Wrapper wp = new EntityWrapper();
        wp.setSqlSelect("sum(other_count_month)");
        Object total = stHospitcalKeyIndicatorMService.selectObj(wp);

        int metadataCount = stEcologicalDatasetService.selectCount(new EntityWrapper<>());

        dataObj.put("hos", hosCount);
        dataObj.put("total", total);
        dataObj.put("metadata", metadataCount);

        log.info("getIndexData:{}",dataObj);
        return dataObj;
    }
}
