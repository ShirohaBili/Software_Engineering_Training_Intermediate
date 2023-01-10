package com.Shiroha.coronavirus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Shiroha.coronavirus.entity.Supply;
import com.Shiroha.coronavirus.service.SupplyService;
import com.github.pagehelper.PageInfo;

@Controller
public class SupplyController {
    @Autowired
    SupplyService supplyService;

    /*
        用户交互界面显示所有药品
     */
    @RequestMapping(value = "/dashboard/supply" ,method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Supply> places = supplyService.getSupplies(page, size);
        PageInfo<Supply> pageInfo=new PageInfo(places);
        model.addAttribute("pageInfo",pageInfo);
        return "supply";
    }

    /*
        用户交互界面搜索
    */
    @RequestMapping(value = "/dashboard/supplyByName")
    public String getSupplyByName(Model model,@RequestParam(name="name",required = true)String name){
        List<Supply> places = supplyService.getSuppliesByName("%" + name + "%");
        PageInfo<Supply> pageInfo=new PageInfo(places);
        if (pageInfo.getSize() == 0){
            return "NoFound";
        }
        model.addAttribute("pageInfo",pageInfo);
        return "supply";
    }

    /*
        管理页面显示所有的药品
     */
    @RequestMapping(value = "/supplyManage",method = RequestMethod.GET)
    public String RedirectToManager(Model model,@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Supply> places = supplyService.getSupplies(page, size);
        PageInfo<Supply> pageInfo=new PageInfo(places);
        model.addAttribute("pageInfo",pageInfo);
        return "supplyManage";
    }

    /*
        管理删除药品
     */
    @RequestMapping("/supplyManage/delete/{id}")
    public String deleteSupply(@PathVariable("id")int id){
        supplyService.deleteSupplyByID(id);
        return "redirect:/supplyManage";
    }
    /*
        管理搜索药品
     */
    @RequestMapping(value = "/supplyManageListByName",method = RequestMethod.GET)
    public String ManageListByName(Model model,@RequestParam(name="name")String name){
        List<Supply> places = supplyService.getSuppliesByName(name);
        PageInfo<Supply> pageInfo=new PageInfo(places);
        if (pageInfo.getSize() == 0){
            return "NoFound";
        }
        model.addAttribute("pageInfo",pageInfo);
        return "supplyManage";
    }

    @RequestMapping(value = "/supplyManage/toAdd")
    public String toAdd(){
        return "supplyAdd";
    }

    @RequestMapping(value = "/supplyManage/supplyAdd",method = RequestMethod.POST)
    public String supplyAdd(@RequestParam("name")String name,
                            @RequestParam("price")String price,@RequestParam("amount")String amount,
                            @RequestParam("illness")String illness){
        Supply supply = new Supply().setName(name).setPrice(price).setAmount(amount).setIllness(illness);
        supplyService.insertSupply(supply);
        return "redirect:/supplyManage";
    }

}
