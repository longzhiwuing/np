package com.cecdat.np.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/17
 * Time: 17:41
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(value = {"/index","/"})
    public String index(Model model) {
        return "admin/index";
    }
}

