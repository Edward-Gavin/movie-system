package com.xiaokea.demo.mapper;


import com.xiaokea.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {

    @Select("select * from question")
    List<Question> getAllQuestion();

    @Select("select * from question where type=#{type}")
    List<Question> getByType(String type);

}
