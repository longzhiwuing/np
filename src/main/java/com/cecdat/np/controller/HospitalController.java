package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 住院情况Controller
 * @author: jcl
 * Date: 2018/06/25
 * Time: 17:24
 */
@RestController
@Slf4j
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    //查询各家医院入院人次
    @GetMapping("/api/hospital/admissionNum.json")
    public JSONObject hospitalJsonAdmissionNum(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return hospitalService.getEchartDataAdmissionNum(startDate,endDate);
    }

    //查询各家医院出院人次
    @GetMapping("/api/hospital/outNum.json")
    public JSONObject hospitalJsonOutNum(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return hospitalService.getEchartDataOutNum(startDate,endDate);
    }

    //查询各家医院出院者平均住院日
    @GetMapping("/api/hospital/averageHospitalDay.json")
    public JSONObject hospitalJsonAverageHospitalDay(String startDate,String endDate) {
        return hospitalService.getEchartDataAverageHospitalDay(startDate,endDate);
    }

    //查询各家医院床位使用率
    @GetMapping("/api/hospital/bedUseRatio.json")
    public JSONObject hospitalJsonBedUseRatio(String startDate,String endDate) {
        return hospitalService.getEchartDataBedUseRatio(startDate,endDate);
    }

    //查询各家医院手术人数
    @GetMapping("/api/hospital/operatioRens.json")
    public JSONObject hospitalJsonOperatioRens(String startDate,String endDate) {
        return hospitalService.getEchartDataOperatioRens(startDate,endDate);
    }

    //查询各家医院死亡人数
    @GetMapping("/api/hospital/deathRens.json")
    public JSONObject hospitalJsonDeathRens(String startDate,String endDate) {
        return hospitalService.getEchartDataDeathRens(startDate,endDate);
    }

    //查询各家医院实际占用总床日数
    @GetMapping("/api/hospital/bedUseNum.json")
    public JSONObject hospitalJsonBedUseNum(String startDate,String endDate) {
        return hospitalService.getEchartDataBedUseNum(startDate,endDate);
    }
/*
    @GetMapping("/api/hospital/table.json")
    public BootStrapTableData tableData(@RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber,
                                        @RequestParam(value = "sortName",required = false) String sortName,
                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                        @RequestParam(value = "searchText",required = false) String searchText) {
        BootStrapTableData<SignBill> data = hospitalService.getTableData(pageSize, pageNumber, sortName, sortOrder, searchText);
        return data;
    }*/
    @GetMapping("/api/outBedNum/echart.json")
    @ResponseBody
    public JSONObject outBedNumJson(@RequestParam(value="startDate") String startDate,
                                    @RequestParam(value="endDate") String endDate) {
        return hospitalService.getOutBedNumEchartData(startDate,endDate);
    }

    @GetMapping("/api/docLoadBedCount/echart.json")
    @ResponseBody
    public JSONObject docLoadBedCountJson(@RequestParam(value="startDate") String startDate,
                                          @RequestParam(value="endDate") String endDate) {
        return hospitalService.getDocLoadBedCountEchartData(startDate,endDate);
    }

    @RequestMapping("/api/selectOperationNumberSum.json")
    @ResponseBody
    public JSONObject selectOperationNumberSum(@RequestParam(value="startDate") String startDate,
                                               @RequestParam(value="endDate") String endDate ) {
        return hospitalService.getOperationNumberSumEchartsData(startDate,endDate);
    }
}
