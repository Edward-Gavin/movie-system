package com.xiaokea.demo.mapper;


import com.xiaokea.demo.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StandardMapper {
    @Select("Select id, name, type, num, content, use_range from standard where name LIKE CONCAT(CONCAT('%', #{name}), '%');")
    List<Standard> getStandardByName(@Param( "name" ) String name);

    @Select("Select id, name, type, num, content, use_range from standard where type LIKE CONCAT(CONCAT('%', #{type}), '%');")
    List<Standard> getStandardByType(@Param( "type" ) String type);

    @Select("Select id, name, type, num, content, use_range from standard where num LIKE CONCAT(CONCAT('%', #{num}), '%');")
    List<Standard> getStandardByNum(@Param( "num" ) String num);

    @Select("Select id, name, type, num, content, use_range from standard where content LIKE CONCAT(CONCAT('%', #{content}), '%');")
    List<Standard> getStandardByContent(@Param( "content" ) String content);

    @Select("Select id, name, type, num, content, use_range from standard where use_range LIKE CONCAT(CONCAT('%', #{use_range}), '%');")
    List<Standard> getStandardByRange(@Param( "use_range" ) String use_range);
}
