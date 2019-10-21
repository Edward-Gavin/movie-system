package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: Edward Gavin
 * @Create: 2019-10-21 16:24
 */
@Controller
@Slf4j
public class DocumentController {
    @RequestMapping("/documents/standard")
    public String searchStandard(Model model) {


        return "documents/standard";
    }

    @RequestMapping("/documents/operate_course")
    public String operateCourse(Model model) {

        return "documents/operate_course";
    }

    @RequestMapping("/documents/handbook")
    public String getHandbook(Model model) {

        return "documents/handbook";
    }

    @RequestMapping("/documents/stand_details")
    public String getStandardDetails(Model model) {

        return "documents/stand_details";
    }

    @RequestMapping("/documents/operate_details")
    public String getOperateDetails(Model model) {

        return "documents/operate_details";
    }

    @RequestMapping("/documents/hand_details")
    public String getHandbookDetails(Model model) {

        return "documents/hand_details";
    }
}
