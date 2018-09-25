package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;

import com.cecdat.np.service.OutpatientAnalysisService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IntelliJ IDEA.
 *
 * @author: hezhuangzhuang@cecdat.com
 * Date: 2018/6/25
 * Time: 12:34
 * 门诊情况汇总分析控制层
 */
@Controller
@Slf4j
public class OutpatientAnalysisController {
    @Autowired
    OutpatientAnalysisService outpatientAnalysisService;
    @GetMapping("/outpatientAnalysis")
    public String outpatientAnalysis(Model model) {
        return "outpatient";
    }

    /**
     * 门急诊人次=sum(门急诊人次)
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectDispRegisterNumByTime.json")
    @ResponseBody
    public JSONObject selectDispRegisterNumByTime(@RequestParam(value="startDate") String startDate,
                                @RequestParam(value="endDate") String endDate ) {
        JSONObject jsonObject = outpatientAnalysisService.getDispRegisterNumByTimeEchartData(startDate,endDate);
        System.out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    /**
     * 人均费用=门诊收入/门急诊人次
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/avgFeeByPeople.json")
    @ResponseBody
    public JSONObject avgFeeByPeople(@RequestParam(value="startDate") String startDate,
                               @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getAvgFeeByPeopleEchartData(startDate,endDate);
    }

    /**
     * 药占比=门诊药品收入/门诊收入
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectMedicineProportion.json")
    @ResponseBody
    public JSONObject selectMedicineProportion(@RequestParam(value="startDate") String startDate,
                                     @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getMedicineProportionEchartData(startDate,endDate);
    }

    /**
     * 耗材料费占比=门诊卫生材料收入/门诊收入
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectConsumablesProportion.json")
    @ResponseBody
    public JSONObject selectConsumablesProportion(@RequestParam(value="startDate") String startDate,
                                               @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getConsumablesProportionEchartsData(startDate,endDate);
    }

    /**
     * 检查费占比=门诊检查收入/门诊收入
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectCheckFeeProportion.json")
    @ResponseBody
    public JSONObject selectCheckFeeProportion(@RequestParam(value="startDate") String startDate,
                                                  @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getCheckFeeProportionEchartsData(startDate,endDate);
    }

    /**
     * 化验费占比=门诊化验收入/门诊收入
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectLaboratoryFeeProportion.json")
    @ResponseBody
    public JSONObject selectLaboratoryFeeProportion(@RequestParam(value="startDate") String startDate,
                                                  @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getLaboratoryFeeProportionEchartsData(startDate,endDate);
    }

    /**
     * 门诊手术例数=sum（门诊手术例数）
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectDisp0perationNumSum.json")
    @ResponseBody
    public JSONObject selectDisp0perationNumSum(@RequestParam(value="startDate") String startDate,
                                               @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getDisp0perationNumSumEchartsData(startDate,endDate);
    }

    /**
     * 门急诊处方数=sum（门急诊处方数和）
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectPrescribeDispNumSum.json")
    @ResponseBody
    public JSONObject selectPrescribeDispNumSum(@RequestParam(value="startDate") String startDate,
                                                @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getPrescribeDispNumSumEchartsData(startDate,endDate);
    }

    /**
     * 专家门诊人次=sum(专家门诊人次和)
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/api/selectDispProfessionNumSum.json")
    @ResponseBody
    public JSONObject selectDispProfessionNumSum(@RequestParam(value="startDate") String startDate,
                                                @RequestParam(value="endDate") String endDate ) {
        return outpatientAnalysisService.getDispProfessionNumSumEchartsData(startDate,endDate);
    }


    @GetMapping("/api/docAvgOeManTime/echart.json")
    @ResponseBody
    public JSONObject docAvgOeManTimeJson(@RequestParam(value="startDate") String startDate,
                                          @RequestParam(value="endDate") String endDate) {
        return outpatientAnalysisService.getDocAvgOeManTimeEchartData(startDate,endDate);
    }

    @GetMapping("/api/dispFeeProportion/echart.json")
    @ResponseBody
    public JSONObject dispFeeProportionJson(@RequestParam(value="startDate") String startDate,
                                           @RequestParam(value="endDate") String endDate) {
        return outpatientAnalysisService.getDispFeeProportionEchartPieData(startDate,endDate);
    }
}

