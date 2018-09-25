package com.cecdat.np.controller;


import com.cecdat.np.dto.BootStrapTableData;
import com.cecdat.np.entity.StEcologicalDataset;
import com.cecdat.np.entity.StHospitalDataset;
import com.cecdat.np.entity.StHospitalStandardDataset;
import com.cecdat.np.entity.StStandDrs;
import com.cecdat.np.service.StHospitalDatasetService;
import com.cecdat.np.service.StHospitalStandDatasetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * st_hospital_dataset 前端控制器
 * </p>
 *
 * @author chenzhongyong@cecdat.com
 * @since 2018-06-29
 */
@Controller
@Slf4j
public class StHospitalDatasetController {
    @Autowired
    private StHospitalDatasetService stHospitalDatasetService;

    @Autowired
    StHospitalStandDatasetService stHospitalStandDatasetService;

    @GetMapping("/api/selectDataSet.json")
    @ResponseBody
    public BootStrapTableData selectDataSet(@RequestParam("pageSize") int pageSize,
                                            @RequestParam("pageNumber") int pageNumber,
                                            @RequestParam(value = "sortName",required = false) String sortName,
                                            @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                            @RequestParam(value = "searchText",required = false) String searchText) {
//        log.info("pageSize:{},pageNumber:{},sortOrder:{},sortName:{},searchText:{}", pageSize, pageNumber, sortOrder,sortName,searchText);
        BootStrapTableData<StHospitalDataset> data = stHospitalDatasetService.getTableData(pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }

    @GetMapping("/api/selectStandDataSet.json")
    @ResponseBody
    public BootStrapTableData selectStandDataSet(@RequestParam("pageSize") int pageSize,
                                            @RequestParam("pageNumber") int pageNumber,
                                            @RequestParam(value = "sortName",required = false) String sortName,
                                            @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                            @RequestParam(value = "searchText",required = false) String searchText) {
        BootStrapTableData<StHospitalStandardDataset> data = stHospitalStandDatasetService.getTableData(pageSize, pageNumber,sortName,sortOrder,searchText);
        return data;
    }

    @GetMapping("/api/selectDataSetDetail.json")
    @ResponseBody
    public BootStrapTableData selectDataSetDetail(@RequestParam("pageSize") int pageSize,
                                                  @RequestParam("pageNumber") int pageNumber,
                                                  @RequestParam(value = "sortName",required = false) String sortName,
                                                  @RequestParam(value = "sortOrder",required = false) String sortOrder,
                                                  @RequestParam(value = "searchText",required = false) String searchText,
                                                  @RequestParam(value = "id",required = false) String id) {
        BootStrapTableData<StStandDrs> data = stHospitalStandDatasetService.getTableDataById(pageSize, pageNumber,sortName,sortOrder,searchText,id);
        return data;
    }

}

