package com.cecdat.np.controller;

import com.cecdat.np.entity.StHospitalDataset;
import com.cecdat.np.entity.StHospitalStandardDataset;
import com.cecdat.np.service.StHospitalStandDatasetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/28
 * Time: 10:28
 */
@Controller
@RequestMapping("/dataStand/classify/")
@Slf4j
public class DatasetController {

    @Autowired
    StHospitalStandDatasetService stHospitalStandDatasetService;

    @ModelAttribute
    public void addMainPage(@RequestParam(value = "id",required = false) String datasetStrucId,Model model) {
        log.info("DatasetController...datasetStrucId:" + datasetStrucId);
        model.addAttribute("mainPage","dataStand");
        StHospitalStandardDataset dataInfo = stHospitalStandDatasetService.getDataInfo(datasetStrucId);
        model.addAttribute("datasetStrucId", datasetStrucId);
        model.addAttribute("orgName", dataInfo.getMedicalOrgName());
        model.addAttribute("dataTotal", dataInfo.getDataTotal());
        model.addAttribute("drsRows", dataInfo.getDrsRows());
        model.addAttribute("datasetName", dataInfo.getDatasetName());
        model.addAttribute("businessSystem", dataInfo.getBusinessSystem());
        model.addAttribute("applicationTheme", dataInfo.getApplicationTheme());
    }

    @GetMapping("dsDesc")
    public String dsDesc(Model model) {
        model.addAttribute("page", "ds_desc");
        return "dataSet/desc";
    }

    @GetMapping("dsMetadata")
    public String dsMetadata(Model model) {
        model.addAttribute("page", "ds_metadata");
        return "dataSet/metaData";
    }

    @GetMapping("dsAssociateData")
    public String hosDataset(Model model) {
        model.addAttribute("page", "ds_associatingData");
        return "dataSet/associateData";
    }
}
