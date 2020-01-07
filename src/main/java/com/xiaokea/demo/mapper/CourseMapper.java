package com.xiaokea.demo.mapper;

import com.xiaokea.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select( "select * from course where name = #{name} or type = #{type}" )
    List<Course> findByCourseByName( @Param("name") String name,
                                     @Param("type") String type);

}
