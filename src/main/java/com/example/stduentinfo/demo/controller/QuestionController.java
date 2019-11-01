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
@RequestMapping("/question")
public class QuestionController {
    @RequestMapping("/question")
    public String question(Model model) {

        return "question/question";
    }

    @RequestMapping("/details")
    public String details(Model model) {

        return "question/details";
    }


    @RequestMapping("/online")
    public String online(Model model) {

        return "question/online";
    }


    @RequestMapping("/insert")
    public String insert(Model model) {

        return "question/insert";
    }

    @RequestMapping("/score")
    public String score(){
        return "question/score";
    }

}
