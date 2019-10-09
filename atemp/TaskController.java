package com.example.stduentinfo.demo.controller;

import com.example.stduentinfo.demo.entity.RegisterInfoYanzheng;
import com.example.stduentinfo.demo.entity.TaskInfo;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-08 18:53
 */
public class TaskController {

    @RequestMapping("/toSaveTask")
    public String saveTask(TaskInfo taskInfo) {
        return null;
    }

    @RequestMapping("/toSaveTask")
    public String registering(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map<String, String> map) throws IOException {
        httpServletResponse.setContentType("text/html;charset=utf-8");
        String username = httpServletRequest.getParameter("taskName");
        String password = httpServletRequest.getParameter("publicUser");
        String password1 = httpServletRequest.getParameter("status");
        String QQ = httpServletRequest.getParameter("startDate");
        String sex = httpServletRequest.getParameter("endDate");
        String birthday = httpServletRequest.getParameter("reponsible");
        return null;
    }
}
