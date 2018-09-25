package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.service.StHospitcalInfoService;
import com.cecdat.np.service.StHospitcalKeyIndicatorMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roy on 2018/6/28.
 */
@Controller
@Slf4j
public class MedicalBigDataController {
    @Autowired
    private StHospitcalInfoService hospitcalInfoService;

    @Autowired
    private StHospitcalKeyIndicatorMService hospitcalKeyIndicatorMService;

    @GetMapping("/api/hospital/data/showChart.json")
    @ResponseBody
    public JSONObject ShowHosNameAndCountCharts() {
        return hospitcalInfoService.selectNameAndCount();
    }

    @GetMapping("/api/hospital/sys/data/showChart.json")
    @ResponseBody
    public JSONObject ShowHosSysNameAndCountCharts() {
        return hospitcalKeyIndicatorMService.selectSysNameAndCount();
    }
}
