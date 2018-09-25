package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.service.StHospitcalKeyIndicatorMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/28
 * Time: 10:28
 */
@Controller
public class DataServiceController {
    @Autowired
    private StHospitcalKeyIndicatorMService hospitcalKeyIndicatorMService;

    @ModelAttribute
    public void addMainPage(Model model) {
        model.addAttribute("mainPage","dataServ");
    }

    @GetMapping(value = {"/dataServ","/dataServ/dataRes"})
    public String dataRes(Model model) {
        JSONObject jsonObject = hospitcalKeyIndicatorMService.getResourceData();
        model.addAttribute("resource",jsonObject);
        model.addAttribute("page","dataRes");
        return "dataServ/dataRes";
    }

    @GetMapping("/dataServ/metadataInfo")
    public String metadataInfo(Model model) {
        model.addAttribute("page","metadataInfo");
        return "dataServ/metadataInfo";
    }

    @GetMapping("/dataServ/hosDataset")
    public String hosDataset(Model model) {
        model.addAttribute("page","hosDataset");
        return "dataServ/hosDataset";
    }
}
