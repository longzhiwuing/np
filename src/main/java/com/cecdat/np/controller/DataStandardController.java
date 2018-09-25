package com.cecdat.np.controller;

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
public class DataStandardController {

    @ModelAttribute
    public void addMainPage(Model model) {
        model.addAttribute("mainPage","dataStand");
    }

    @GetMapping(value = {"/dataStand","/dataStand/hosMetadata"})
    public String dataRes(Model model) {
        model.addAttribute("page","hosMetadata");
        return "dataStand/hosMetadata";
    }

    @GetMapping("/dataStand/drsMetadata")
    public String dataDrs(Model model) {
        model.addAttribute("page","drsMetadata");
        return "dataStand/drsMetadata";
    }


}
