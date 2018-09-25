package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.DemoData;
import com.cecdat.np.service.DemoDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/15
 * Time: 20:34
 */
@Controller
@Slf4j
public class DemoController {

    @Autowired
    DemoDataService demoDataService;

    @GetMapping("/demo")
    public String demo(Model model) {
        log.info("this is a demo...bbb");
        model.addAttribute("name", "springboot!");
        return "demo";
    }

    @GetMapping("/api/demo/table.json")
    @ResponseBody
    public BootStrapTableData tableData(@RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber,
                                        @RequestParam(value = "sortName",required = false) String sortName,
                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                        @RequestParam(value = "searchText",required = false) String searchText) {
        log.info("pageSize:{},pageNumber:{},sortOrder:{},sortName:{},searchText:{}", pageSize, pageNumber, sortOrder,sortName,searchText);
        BootStrapTableData<DemoData> data = demoDataService.getTableData(pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }

    @GetMapping("/api/demo/echart.json")
    @ResponseBody
    public JSONObject demoJson() {
        return demoDataService.getEchartData();
    }
}
