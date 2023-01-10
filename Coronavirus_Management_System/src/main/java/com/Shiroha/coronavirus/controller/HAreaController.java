package com.Shiroha.coronavirus.controller;

import com.Shiroha.coronavirus.entity.Area;
import com.Shiroha.coronavirus.service.AreaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class HAreaController {

    @Autowired
    AreaService areaService;

    //初始化管理员列表
    @RequestMapping(value = "/harea/list" ,method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Area> areas = areaService.findAll();
        PageInfo<Area> pageInfo=new PageInfo(areas);
        model.addAttribute("pageInfo",pageInfo);
        return "harealist";
    }

    //跳转添加页面
    @RequestMapping(value = "/harea/toAdd")
    public String toAdd(){
        return "hareaAdd";
    }

    //添加地区功能
    @RequestMapping(value = "/harea/add",method = RequestMethod.POST)
    public String add(@RequestParam("id")int id,
                      @RequestParam("address")String address,
                      @RequestParam("level") int level){
        Area area=new Area().setId(id).setAddress(address).setLevel(level);
        System.out.println(area);
        //添加用户
        areaService.add(area);

        return "redirect:/harea/list";
    }

    //更改风险级别
    @RequestMapping("/harea/toSuper/{id}")
    public String toSuper(@PathVariable("id")int id){
        Area area = areaService.findByID(id);
        area.setLevel(1);
        areaService.update(area);
        return "redirect:/harea/list";
    }
    //删除地区
    @RequestMapping("/harea/delete/{id}")
    public String delete(@PathVariable("id")int id){
        areaService.deleteArea(id);
        return "redirect:/harea/list";
    }

    //查找地区
    @RequestMapping(value ="harea/listByName",method = RequestMethod.GET)
    public String listByName(Model model,@RequestParam(name="name")String name){
        Area area = areaService.findByName("%" + name + "%");
        if (area == null){
            return "NoFound";
        }
        List<Area> areas = new LinkedList<>();
        areas.add(area);
        PageInfo<Area> pageInfo=new PageInfo(areas);
        model.addAttribute("pageInfo",pageInfo);
        return "harealist";
    }

    @RequestMapping(value ="dashboard/AreaListByName")
    public String listByNameForUser(Model model,@RequestParam(name="name")String name){
        Area area = areaService.findByName("%" + name + "%");
        if (area == null){
            return "NoFound";
        }
        List<Area> areas = new LinkedList<>();
        areas.add(area);
        PageInfo<Area> pageInfo=new PageInfo(areas);
        model.addAttribute("pageInfo",pageInfo);
        return "area";
    }

    @RequestMapping(value = "/dashboard/Area" ,method = RequestMethod.GET)
    public String listForUser(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Area> areas = areaService.findAll();
        PageInfo<Area> pageInfo=new PageInfo(areas);
        model.addAttribute("pageInfo",pageInfo);
        return "area";
    }
}
