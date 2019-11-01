package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-01 15:44
 */

@Controller
@Slf4j
@RequestMapping("/course")
public class CourseController {

    @RequestMapping("/online_course")
    public String onlineCourse(){
        return "course/online_course";
    }
}
