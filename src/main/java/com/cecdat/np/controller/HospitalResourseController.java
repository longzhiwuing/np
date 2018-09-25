package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.dto.TotalCostData;
import com.cecdat.np.service.HospitalResourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 医院资源分析,床位明细Controller
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/25
 * Time: 23:47
 */
@Controller
@Slf4j
public class HospitalResourseController {

    @Autowired
    HospitalResourseService hospitalResourseService;

    @GetMapping("/MyIndex")
    public String show() {

        return "hospital_resourse";
    }

    @GetMapping("/api/doctorCount/echart.json")
    @ResponseBody
    public JSONObject doctorCountJson(@RequestParam(value="startDate") String startDate,
                                   @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getDoctorCountEchartData(startDate,endDate);
    }

    @GetMapping("/api/nurseCount/echart.json")
    @ResponseBody
    public JSONObject nurseCountJson(@RequestParam(value="startDate") String startDate,
                                   @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getNurseCountEchartData(startDate,endDate);
    }

    @GetMapping("/api/docNurseRatio/echart.json")
    @ResponseBody
    public JSONObject docNurseRatioJson(@RequestParam(value="startDate") String startDate,
                                   @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getDocNurseRatioEchartData(startDate,endDate);
    }

    @GetMapping("/api/docBedRatio/echart.json")
    @ResponseBody
    public JSONObject docBedRatioJson(@RequestParam(value="startDate") String startDate,
                                   @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getDocBedRatioEchartData(startDate,endDate);
    }

    @GetMapping("/api/oEManTime/echart.json")
    @ResponseBody
    public JSONObject oEManTimeJson(@RequestParam(value="startDate") String startDate,
                                   @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getOEManTimeEchartData(startDate,endDate);
    }

    @GetMapping("/api/bedOpenNum/echart.json")
    @ResponseBody
    public JSONObject bedOpenNumJson(@RequestParam(value="startDate") String startDate,
                                    @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getBedOpenNumEchartData(startDate,endDate);
    }

    @GetMapping("/api/bedOpenCount/echart.json")
    @ResponseBody
    public JSONObject bedOpenCountJson(@RequestParam(value="startDate") String startDate,
                                     @RequestParam(value="endDate") String endDate) {
        return hospitalResourseService.getBedOpenCountEchartData(startDate,endDate);
    }


    @GetMapping("/api/totalCost/table.json")
    @ResponseBody
    public BootStrapTableData tableData(@RequestParam(value = "startDate",required = false) String startDate,
                                        @RequestParam(value = "endDate",required = false) String endDate,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber,
                                        @RequestParam(value = "sortName",required = false) String sortName,
                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                        @RequestParam(value = "searchText",required = false) String searchText) {
        log.info("startDate:{},endDate:{},pageSize:{},pageNumber:{},sortOrder:{},sortName:{},searchText:{}", startDate, endDate, pageSize, pageNumber, sortOrder,sortName,searchText);
        BootStrapTableData<TotalCostData> data = hospitalResourseService.getTotalCostTableData(startDate,endDate,pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }
}
