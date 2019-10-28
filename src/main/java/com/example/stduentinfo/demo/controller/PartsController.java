package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-28 18:23
 */
@Controller
@Slf4j
@RequestMapping("/base/parts")
public class PartsController {


    @RequestMapping("/show")
    public String showParts(HttpServletRequest httpServletRequest, Model model) {

        return "base/parts/show";
    }


    @RequestMapping("/search")
    public String searchParts(HttpServletRequest httpServletRequest, Model model) {

        return "base/parts/search";
    }

    @RequestMapping("/insert")
    public String insertParts(HttpServletRequest httpServletRequest, Model model) {

        return "base/parts/insert";
    }
}
