package com.cecdat.np.controller;

import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.StEcologicalDataset;
import com.cecdat.np.service.StEcologicalDatasetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class StEcologicalDatasetController {

    @Autowired
    private StEcologicalDatasetService stEcologicalDatasetService;

    @GetMapping("/api/selectEcologicalDataset.json")
    @ResponseBody
    public BootStrapTableData tableData(@RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber,
                                        @RequestParam(value = "sortName",required = false) String sortName,
                                        @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                        @RequestParam(value = "searchText",required = false) String searchText) {
        log.info("pageSize:{},pageNumber:{},sortOrder:{},sortName:{},searchText:{}", pageSize, pageNumber, sortOrder,sortName,searchText);
        BootStrapTableData<StEcologicalDataset> data = stEcologicalDatasetService.getTableData(pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }


}
