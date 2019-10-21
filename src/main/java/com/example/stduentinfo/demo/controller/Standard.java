package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-18 16:16
 */
@Controller
@Slf4j
public class Standard {

    @RequestMapping("/base/standard/search")
    public String standardSearch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "base/standard/search";
    }

    @RequestMapping("/base/standard/insert")
    public String standardSearch() {
        return "base/standard/insert";
    }

    @RequestMapping("/base/standard/upload")
    public String standardUpload() {
        return "base/standard/upload";
    }

}
