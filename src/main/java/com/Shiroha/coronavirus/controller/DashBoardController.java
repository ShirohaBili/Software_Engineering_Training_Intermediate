package com.Shiroha.coronavirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@Controller
public class DashBoardController {
    @RequestMapping(value = "/to/dashboard")
    public String toDashBoards() {
        return "dashboard";
    }

    @RequestMapping(value = "/dashboard/vaccination")
    public String toVaccination() {
        return "vaccination";
    }

    @RequestMapping(value = "/dashboard/acidTest")
    public String toAcidTest() {
        return "nucleicAcidTest";
    }

    @RequestMapping(value = "/dashboard/supply")
    public String toSupply() {
        return "supply";
    }

    @RequestMapping(value = "/noAccess")
    public String toNoAccess() {
        return "noAccess";
    }
}
