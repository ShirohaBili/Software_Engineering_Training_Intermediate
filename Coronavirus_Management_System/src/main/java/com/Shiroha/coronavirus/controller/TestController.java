package com.Shiroha.coronavirus.controller;

import com.Shiroha.coronavirus.entity.TestPlace;
import com.Shiroha.coronavirus.entity.User;
import com.Shiroha.coronavirus.service.TestPlaceService;
import com.Shiroha.coronavirus.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    TestPlaceService testPlaceService;

    @RequestMapping(value = "/dashboard/acidTest" ,method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<TestPlace> places = testPlaceService.getTestPlaces(page, size);
        PageInfo<TestPlace> pageInfo=new PageInfo(places);
        model.addAttribute("pageInfo",pageInfo);
        return "nucleicAcidTest";
    }

    //按名字查找地点
    @RequestMapping(value = "/dashboard/acidTest/listByName")
    public String listByName(Model model, @RequestParam(name = "name", required = true) String name){
        List<TestPlace> places = testPlaceService.getTestPlacesByName(name);
        PageInfo<TestPlace> pageInfo=new PageInfo(places);
        if (pageInfo.getSize() == 0){
            return "NoFound";
        }
        model.addAttribute("pageInfo",pageInfo);
        return "nucleicAcidTest";
    }
}
