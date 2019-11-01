package com.xiaokea.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-28 18:43
 */

@Controller
@Slf4j
@RequestMapping("/assets")
public class AssetsController {

    @RequestMapping("/show")
    public String showAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/show";
    }


    @RequestMapping("/search")
    public String searchAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/search";
    }

    @RequestMapping("/insert")
    public String insertAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/insert";
    }
}
