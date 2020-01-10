package com.xiaokea.demo.service;

import com.xiaokea.demo.entity.Course;
import com.xiaokea.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2020-01-07 20:30
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findCourseByNameAndType(String name, String type){
        return courseMapper.findByCourseByName(name, type);
    }

    public Course findCourseById(String id){
        return courseMapper.findCourseByid(id);
    }

}
