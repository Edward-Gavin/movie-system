package com.example.stduentinfo.demo.service;

import com.example.stduentinfo.demo.entity.Cinema;
import com.example.stduentinfo.demo.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-15 15:49
 */
@Service
public class CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    //查询学生信息功能（通过用户名查询学生所有信息）
    public Cinema findByAll(String cinemaName, String province, String city, String responsible){
        return cinemaMapper.findByAllParam(cinemaName, province, city, responsible);
    }
}
