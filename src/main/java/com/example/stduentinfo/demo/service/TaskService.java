package com.example.stduentinfo.demo.service;

import com.example.stduentinfo.demo.entity.Task;
import com.example.stduentinfo.demo.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-23 19:07
 */
@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public void save(String title,
                     String equipment,
                     String publish,
                     String detail,
                     String date,
                     String start,
                     String end,
                     String responsible,
                     Integer status) {
        taskMapper.save(title, equipment, publish,
                detail,date, start,end,responsible, status);
    }

    public List<Task> findAll() {
        return taskMapper.findAll();
    }

    public List<Task> findByResponsible(String responsible) {

        return taskMapper.findByResponsible(responsible);
    }

}
