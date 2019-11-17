package com.xiaokea.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-17 15:58
 */
@Controller
@RequestMapping("/star")
public class StarController {

    @RequestMapping("/search")
    public String starSearch() {
        return "star/search";
    }

    @RequestMapping("/insert")
    public String starInsert() {
        return "star/insert";
    }



}
