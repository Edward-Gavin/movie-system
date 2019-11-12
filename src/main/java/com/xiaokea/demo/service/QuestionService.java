package com.xiaokea.demo.service;

import com.xiaokea.demo.entity.Question;
import com.xiaokea.demo.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-06 19:43
 */

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> getAllQuestion() {
        return questionMapper.getAllQuestion();
    }

    public List<Question> getQuestionByType(String type) {
        return questionMapper.getByType(type);
    }

}
