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
        return cinemaMapper.findByCPCR(cinemaName, province, city, responsible);
    }

    public void saveCinema(Integer id, String cinemaName, String province, String city, String address ,
                           String responsible, String responsiblePhone, String manager ,
                           String managerPhone, String roomNumber) {
        cinemaMapper.save(id, cinemaName, province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber);
    }

    public List<Cinema> findByPCR(String province, String city, String responsible) {
        return cinemaMapper.findByProvinceAndCityAndResponsible(province, city, responsible);
    }

    public List<Cinema> findByPCN(String province, String city, String cinemaName) {
        return cinemaMapper.findByProvinceAndCityAndCName(province, city, cinemaName);
    }

    public Cinema findById(Integer id) {
        return cinemaMapper.findById(id);
    }

    public void updateById(String cinemaName, String province, String city, String address,
                           String responsible, String responsiblePhone, String manager,
                           String managerPhone, String roomNumber, Integer id) {
        cinemaMapper.updateById(cinemaName, province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber, id);
    }
}
