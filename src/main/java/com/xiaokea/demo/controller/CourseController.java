package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.Course;
import com.xiaokea.demo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-01 15:44
 */

@Controller
@Slf4j
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/online_course")
    public String onlineCourse(Model model){
        List<Course> courseAll = courseService.findCourseAll();
        model.addAttribute("courses", courseAll);

        return "course/online_course";
    }

    @RequestMapping("/search")
    public String cinemaSearch(Model model, HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String type = httpServletRequest.getParameter("type");

        log.info(name);
        log.info(type);

        List<Course> courses = courseService.findCourseByNameAndType(name, type);
        System.out.println(courses.toString());
        model.addAttribute("courses", courses);
        return "course/online_course";
    }

    @RequestMapping(value = "/course/{course}", method = RequestMethod.GET)
    public String courseDetails(Model model, @PathVariable String course) {
        Course course1 = courseService.findCourseById(course);
        model.addAttribute("course1", course1);
        return "course/video_details";
    }


}
