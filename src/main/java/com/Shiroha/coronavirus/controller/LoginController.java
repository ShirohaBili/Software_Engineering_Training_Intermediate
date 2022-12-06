package com.Shiroha.coronavirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value = "login")
    public String tologin(){
//        System.out.println(userName);
//        System.out.println(password);
        return "login";
    }
}
