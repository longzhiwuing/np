package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.SignBill;
import com.cecdat.np.service.SignBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/21
 * Time: 14:27
 */
@Controller
@Slf4j
public class SignBillController {

    @Autowired
    SignBillService signBillService;

    @GetMapping("/hospital")
    public String hospital() {
        return "hospital";
    }

    @GetMapping("/show")
    public String show(Model model) {

        return "show";
    }

    @GetMapping("/api/signBill/table.json")
    @ResponseBody
    public BootStrapTableData tableData(@RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber,
                                        @RequestParam(value = "sortName",required = false) String sortName,
                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                        @RequestParam(value = "searchText",required = false) String searchText) {
        log.info("pageSize:{},pageNumber:{},sortOrder:{},sortName:{},searchText:{}", pageSize, pageNumber, sortOrder,sortName,searchText);
        BootStrapTableData<SignBill> data = signBillService.getTableData(pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }

    @GetMapping("/api/signBill/echart.json")
    @ResponseBody
    public JSONObject signBillJson() {
        return signBillService.getEchartData();
    }

    @GetMapping("/api/signBill/echartPie.json")
    @ResponseBody
    public JSONObject signBillPieJson() {
        return signBillService.getEchartPieData();
    }
}
