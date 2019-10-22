package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-22 19:01
 */
@Controller
@Slf4j
public class QuestionController {
    @RequestMapping("/question/question")
    public String question(Model model) {

        return "question/question";
    }

    @RequestMapping("/question/details")
    public String details(Model model) {

        return "question/details";
    }

}
