package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.Task;
import com.xiaokea.demo.mapper.TaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-13 20:11
 */
@Controller
@Slf4j
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(value = "/post_task", method = RequestMethod.POST)
    @ResponseBody
    public String postTask(HttpServletRequest httpServletRequest) {
        String title = httpServletRequest.getParameter("title");
        String detail = httpServletRequest.getParameter("detail");
        String equipment = httpServletRequest.getParameter("equipment");
        String date = httpServletRequest.getParameter("date");
        String start = httpServletRequest.getParameter("start_time");
        String end = httpServletRequest.getParameter("end_time");
        String staff = httpServletRequest.getParameter("staff");

        String colorString = httpServletRequest.getParameter("color");
        int color = 0;
        if (colorString.equals("rgb(243, 156, 18)")) {
            color = 1;
        }else if(colorString.equals("rgb(189, 33, 48)")){
            color =2;
        }
        HttpSession session = httpServletRequest.getSession();
        String publish = session.getAttribute("username").toString();
        log.info(title);
        log.info(detail);
        log.info(equipment);
        log.info(date);
        log.info(staff);
        log.info(start);
        log.info(end);
        log.info(colorString);

        taskMapper.save(title, equipment, publish, detail, date, start, end, staff,color);
        return title;
    }

    @RequestMapping("/get_task")
    @ResponseBody
    public List<Task> getTask() {
        List<Task> taskAll = taskMapper.findAll();
        return taskAll;
    }

    @RequestMapping("/task/task_search")
    public String taskSearch() {
        return "task/task_search";
    }

    @RequestMapping("/task/calendar_manage")
    public String calendarManage() {
        return "task/calendar_manage";
    }

    @RequestMapping("/searching")
    public String searching(HttpServletRequest httpServletRequest, Model model) {
        String date = httpServletRequest.getParameter("date");
        String responsible = httpServletRequest.getParameter("responsible");
        String equipment = httpServletRequest.getParameter("equipment");
        String title = httpServletRequest.getParameter("title");

        List<Task>  tasks = taskMapper.findByResponsible(responsible);
        model.addAttribute("tasks", tasks);
        return "task/task_search";
    }


}
