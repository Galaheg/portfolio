package com.hemre.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showMyLoginPage(){
        return "security/login-page";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied(){
        return "security/access-denied";
    }

}
