package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.Question;
import com.xiaokea.demo.entity.QuestionResponse;
import com.xiaokea.demo.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-22 19:01
 */
@Controller
@Slf4j
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping("/question")
    public String question(Model model) {
        return "question/question";
    }

    @RequestMapping("/all_questions")
    @ResponseBody
    public List<QuestionResponse> getAllQuestions() {
        List<Question> allQuestions = questionService.getAllQuestion();
        log.info(allQuestions.toString());

        List<QuestionResponse> questionResponses = new ArrayList<>();
        for (Question question : allQuestions) {
            QuestionResponse questionResponse = new QuestionResponse();

            // 题目信息
            questionResponse.setTitle(question.getTitle());

            // 选项信息
            List<String> options = new ArrayList<>();
            options.add(question.getOptionA());
            options.add(question.getOptionB());
            options.add(question.getOptionC());
            options.add(question.getOptionD());
            questionResponse.setOptions(options);

            // 资源地址
            questionResponse.setUrl(question.getUrl());

            // 详情信息
            List<String> details = new ArrayList<>();
            details.add(question.getType());
            details.add(question.getSource());
            details.add(question.getScore());
            questionResponse.setDetails(details);

            questionResponses.add(questionResponse);
        }
        return questionResponses;
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
