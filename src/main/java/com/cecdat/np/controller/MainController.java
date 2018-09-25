package com.cecdat.np.controller;

import com.cecdat.np.auth.UserAuthService;
import com.cecdat.np.auth.UserInfo;
import com.cecdat.np.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/25
 * Time: 11:22
 */
@Controller
@Slf4j
public class MainController {

    @Autowired
    IndexService indexService;

    @Autowired
    UserAuthService userAuthService;

    @GetMapping(value = {"/index","/"})
    public String index(Model model) {
        model.addAttribute("mainPage","index");

        UserInfo userInfo = userAuthService.getUserInfo();
        log.info("登录用户信息:"+userInfo);

        return "index";
    }

    @GetMapping("/api/indexData.json")
    @ResponseBody
    public ResponseEntity indexData() {
        return new ResponseEntity(indexService.getIndexData(), HttpStatus.OK);
    }

    @GetMapping("/bi")
    public String bi() {
        return "bi";
    }
}
