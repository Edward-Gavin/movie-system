package com.xiaokea.demo.mapper;


import com.xiaokea.demo.entity.QuestionResponse;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {

    @Select("select * from question where ")
    List<QuestionResponse> getAllQuestion();

    @Select("select * from question where type=#{type}")
    List<QuestionResponse> getByType();

}
