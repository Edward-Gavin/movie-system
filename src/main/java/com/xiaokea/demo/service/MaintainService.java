package com.xiaokea.demo.service;

import com.xiaokea.demo.entity.Maintain;
import com.xiaokea.demo.mapper.MaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-12-31 14:09
 */
@Service
public class MaintainService {

    @Autowired
    private MaintainMapper maintainMapper;

    public List<Maintain> getMaintainByName(String name) {
        return maintainMapper.getMaintainByName(name);
    }
    public List<Maintain> getMaintainByType(String type) {
        return maintainMapper.getMaintainByType(type);
    }

    public List<Maintain> getMaintainByBrand(String brand) {
        return maintainMapper.getMaintainByBrand(brand);
    }

    public List<Maintain> getMaintainByModel(String model) {
        return maintainMapper.getMaintainByModel(model);
    }
    public Maintain getMaintainById(String id) {
        return maintainMapper.getMaintainById(id);
    }
    public List<Maintain> getMaintainBySearch(String type, String brand, String model, String name) {
        return maintainMapper.getMaintainBySearch(type, brand, model, name);
    }

}
