package com.cecdat.np.controller;

import com.cecdat.np.dto.RegisterForm;
import com.cecdat.np.dto.enums.StatusCode;
import com.cecdat.np.service.KaptchaService;
import com.cecdat.np.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/20
 * Time: 15:49
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    RegisterService registerService;

    @Autowired
    KaptchaService kaptchaService;

    @GetMapping("/login")
    public String loginHtml(@RequestParam(value = "status",required = false) String status, Model model) {
        if (StringUtils.isNotEmpty(status)) {
            log.info("login status:{}", status);
            model.addAttribute("info", StatusCode.getByCodeStr(status));
        }
        return "login/login";
    }

    @GetMapping("/register")
    public String registerHtml() {
        return "login/register";
    }

    @PostMapping("/register")
    public void doRegister(HttpServletResponse response,@Valid RegisterForm form, BindingResult bindingResult) throws Exception{

        log.info("do register...form:{}",form);

        StatusCode regRes = registerService.registerUser(form);

        response.sendRedirect(String.format("/login?status=%s",regRes));
    }

    @GetMapping(value = "/vcode")
    public void getKaptchaImage(HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        kaptchaService.genKaptcha(request, response);
    }
}
