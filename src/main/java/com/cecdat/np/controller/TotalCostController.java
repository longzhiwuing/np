package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.dto.TotalCostData;
import com.cecdat.np.entity.SignBill;
import com.cecdat.np.service.TotalCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全院费用Controller
 * @author: jcl
 * Date: 2018/06/28
 * Time: 10:57
 */
@RestController
@Slf4j
public class TotalCostController {

    @Autowired
    private TotalCostService totalCostService;

    @GetMapping("/api/totalCost/physicByTotal.json")
    public JSONObject hospitalJsonOfPhysicByTotal(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        return totalCostService.getEchartDataOfPhysicByTotal(startDate,endDate);
    }

    @GetMapping("/api/totalCost/materialByTotal.json")
    public JSONObject hospitalJsonOfMaterialByTotal(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        return totalCostService.getEchartDataOfMaterialByTotal(startDate,endDate);
    }

    @GetMapping("/api/totalCost/checkByTotal.json")
    public JSONObject hospitalJsonOfCheckByTotal(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        return totalCostService.getEchartDataOfCheckByTotal(startDate,endDate);
    }

    @GetMapping("/api/totalCost/laboratoryByTotal.json")
    public JSONObject hospitalJsonOfLaboratoryByTotal(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        return totalCostService.getEchartDataOfLaboratoryByTotal(startDate,endDate);
    }

    @GetMapping("/api/totalCost/totalCostPie.json")
    public JSONObject hospitalJsonTotalCost(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        return totalCostService.getEchartPieDataTotalCost(startDate,endDate);
    }

//    @GetMapping("/api/totalCost/table.json")
//    @ResponseBody
//    public BootStrapTableData tableData(@RequestParam("startDate") String startDate,
//                                        @RequestParam("endDate") String endDate,
//                                        @RequestParam("pageSize") int pageSize,
//                                        @RequestParam("pageNumber") int pageNumber,
//                                        @RequestParam(value = "sortName",required = false) String sortName,
//                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
//                                        @RequestParam(value = "searchText",required = false) String searchText) {
//        BootStrapTableData<TotalCostData> data = totalCostService.getTotalCostTableData(startDate,endDate,pageSize, pageNumber,sortName,sortOrder,searchText);
//        return data;
//    }

}
