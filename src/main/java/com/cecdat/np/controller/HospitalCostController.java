package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.service.HospitalCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 住院费用Controller
 * @author: jcl
 * Date: 2018/06/26
 * Time: 20:16
 */
@RestController
@Slf4j
public class HospitalCostController {

    @Autowired
    private HospitalCostService hospitalCostService;

    //查询各家医院住院人均费用
    @GetMapping("/api/hospitalCost/peopleAverageCost.json")
    public JSONObject hospitalJsonPeopleAverageCost(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return hospitalCostService.getEchartDataPeopleAverageCost(startDate,endDate);
    }

    //查询各家医院住院药费占比
    @GetMapping("/api/hospitalCost/physicByHospitalCost.json")
    public JSONObject hospitalJsonPhysicByHospitalCost(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return hospitalCostService.getEchartDataPhysicByHospitalCost(startDate,endDate);
    }

    //查询各家医院住院耗材费占比
    @GetMapping("/api/hospitalCost/materialByHospitalCost.json")
    public JSONObject hospitalJsonMaterialByHospitalCost(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return hospitalCostService.getEchartDataMaterialByHospitalCost(startDate,endDate);
    }

    //查询各家医院住院检查费占比
    @GetMapping("/api/hospitalCost/checkByHospitalCost.json")
    public JSONObject hospitalJsonCheckByHospitalCost(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate) {
        return hospitalCostService.getEchartDataCheckByHospitalCost(startDate,endDate);
    }

    //查询各家医院住院化验费占比
    @GetMapping("/api/hospitalCost/laboratoryByHospitalCost.json")
    public JSONObject hospitalJsonLaboratoryByHospitalCost(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate) {
        return hospitalCostService.getEchartDataLaboratoryByHospitalCost(startDate,endDate);
    }

    @GetMapping("/api/resFeeProportion/echart.json")
    @ResponseBody
    public JSONObject resFeeProportionJson(@RequestParam(value="startDate") String startDate,
                                          @RequestParam(value="endDate") String endDate) {
        return hospitalCostService.getResFeeProportionEchartPieData(startDate,endDate);
    }
}
