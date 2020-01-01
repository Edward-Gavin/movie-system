package com.xiaokea.demo.service;

import com.xiaokea.demo.entity.Malfunction;
import com.xiaokea.demo.mapper.MalfunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-12-31 14:22
 */
@Service
public class MalfunctionService {
    @Autowired
    private MalfunctionMapper malfunctionMapper;

    public List<Malfunction> getMalfunctionByType(String type) {
        return malfunctionMapper.getMalfunctionByType(type);
    }

    public List<Malfunction> getMalfunctionByEquType(String equ_type) {
        return malfunctionMapper.getMalfunctionByEquType(equ_type);
    }

    public List<Malfunction> getMalfunctionByBrand(String brand) {
        return malfunctionMapper.getMalfunctionByBrand(brand);
    }

    public List<Malfunction> getMalfunctionByModel(String model) {
        return malfunctionMapper.getMalfunctionByModel(model);
    }

    public List<Malfunction> getMalfunctionByCode(String code) {
        return malfunctionMapper.getMalfunctionByCode(code);
    }
    public List<Malfunction> getMalfunctionByReturnMg(String return_mg) {
        return malfunctionMapper.getMalfunctionByReturnMg(return_mg);
    }

    public List<Malfunction> getMalfunctionByDetails(String details) {
        return malfunctionMapper.getMalfunctionByDetails(details);
    }
}
