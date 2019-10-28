package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-28 17:23
 */

@Controller
@Slf4j
@RequestMapping("/base/equipment")
public class EquipmentController {


    @RequestMapping("/show")
    public String showEquipment(HttpServletRequest httpServletRequest, Model model) {

        return "base/equipment/show";
    }


    @RequestMapping("/search")
    public String searchEquipment(HttpServletRequest httpServletRequest, Model model) {

        return "base/equipment/search";
    }

    @RequestMapping("/insert")
    public String insertEquipment(HttpServletRequest httpServletRequest, Model model) {

        return "base/equipment/insert";
    }
}
