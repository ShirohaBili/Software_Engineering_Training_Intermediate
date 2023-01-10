package com.Shiroha.coronavirus.controller;

import com.Shiroha.coronavirus.entity.IndexInfo;
import com.Shiroha.coronavirus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    MyUserDetailService userDetailService;
    
    @RequestMapping(value = {"/indexpage", "/" },produces="application/json;charset=UTF-8")
    public String index(Model model){
        return "index";
    }

}

