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
public class HospitalOperationController {

    @ModelAttribute
    public void addMainPage(Model model) {
        model.addAttribute("mainPage","index");
    }

    @GetMapping(value = {"/hosData","/hosRes","/hosRes/hosHR"})
    public String hosData(Model model) {
        model.addAttribute("page","hosRes");
        model.addAttribute("subpage","hosHR");
        return "hosData/hosRes/hosHR";
    }

    @GetMapping("/hosRes/bedRes")
    public String bedRes(Model model) {
        model.addAttribute("page","hosRes");
        model.addAttribute("subpage","bedRes");
        return "hosData/hosRes/bedRes";
    }

    @GetMapping(value = {"/hosMZ","/hosMZ/workload"} )
    public String hosMZWorkload(Model model) {
        model.addAttribute("page","hosMZ");
        model.addAttribute("subpage","workload");
        return "hosData/hosMZ/workload";
    }

    @GetMapping("/hosMZ/workefficiency")
    public String hosMZWorkefficiency(Model model) {
        model.addAttribute("page","hosMZ");
        model.addAttribute("subpage","workefficiency");
        return "hosData/hosMZ/workefficiency";
    }

    @GetMapping("/hosMZ/feectrl")
    public String hosMZFeectrl(Model model) {
        model.addAttribute("page","hosMZ");
        model.addAttribute("subpage","feectrl");
        return "hosData/hosMZ/feectrl";
    }

    @GetMapping("/hosMZ/madeup")
    public String hosMZMadeup(Model model) {
        model.addAttribute("page","hosMZ");
        model.addAttribute("subpage","madeup");
        return "hosData/hosMZ/madeup";
    }

    @GetMapping(value = {"/hosZY","/hosZY/feectrl"})
    public String hosZYFeectrl(Model model) {
        model.addAttribute("page","hosZY");
        model.addAttribute("subpage","feectrl");
        return "hosData/hosZY/feectrl";
    }

    @GetMapping("/hosZY/workload")
    public String hosZYWorkload(Model model) {
        model.addAttribute("page","hosZY");
        model.addAttribute("subpage","workload");
        return "hosData/hosZY/workload";
    }

    @GetMapping("/hosZY/workefficiency")
    public String hosZYWorkefficiency(Model model) {
        model.addAttribute("page","hosZY");
        model.addAttribute("subpage","workefficiency");
        return "hosData/hosZY/workefficiency";
    }

    @GetMapping("/hosZY/madeup")
    public String hosZYMadeup(Model model) {
        model.addAttribute("page","hosZY");
        model.addAttribute("subpage","madeup");
        return "hosData/hosZY/madeup";
    }

    @GetMapping(value = {"/hosAllFee","/hosAllFee/feectrl"})
    public String hosAllFee(Model model) {
        model.addAttribute("page","hosAllFee");
        model.addAttribute("subpage","feectrl");
        return "hosData/hosAllFee/feectrl";
    }

    @GetMapping("/hosAllFee/madeup")
    public String hosAllFeeMadeup(Model model) {
        model.addAttribute("page","hosAllFee");
        model.addAttribute("subpage","madeup");
        return "hosData/hosAllFee/madeup";
    }

    @GetMapping("/hosAllFee/medicalFee")
    public String hosAllFeeMedicalFee(Model model) {
        model.addAttribute("page","hosAllFee");
        model.addAttribute("subpage","medicalFee");
        return "hosData/hosAllFee/medicalFee";
    }

    @GetMapping("/hosAllFee/increaseRate")
    public String hosAllIncreaseRate(Model model) {
        model.addAttribute("page","hosAllFee");
        model.addAttribute("subpage","increaseRate");
        return "hosData/hosAllFee/increaseRate";
    }
}
