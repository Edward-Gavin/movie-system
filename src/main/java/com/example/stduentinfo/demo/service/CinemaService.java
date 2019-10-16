package com.example.stduentinfo.demo.service;

import com.example.stduentinfo.demo.entity.Cinema;
import com.example.stduentinfo.demo.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-15 15:49
 */
@Service
public class CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;


    public List<Cinema> findByProvinceAndCity(String province, String city){
        return cinemaMapper.findByPC(province, city);
    }

    public List<Cinema> find(String cinemaName, String province, String city, String responsible) {
        return cinemaMapper.findById(cinemaName, province, city, responsible);
    }
    public void saveCinema(String cinemaName, String province, String city, String address ,
                           String responsible, String responsiblePhone, String manager ,
                           String managerPhone, String roomNumber) {
        cinemaMapper.save(cinemaName, province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber);
    }
}
