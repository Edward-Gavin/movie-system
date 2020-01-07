package com.xiaokea.demo.service;

import com.xiaokea.demo.entity.Standard;
import com.xiaokea.demo.mapper.StandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-18 16:48
 */
@Service
public class StandardService {
    @Autowired
    private StandardMapper standardMapper;

    public List<Standard> getStandardByName(String name) {
        return standardMapper.getStandardByName(name);
    }

    public List<Standard> getStandardByType(String type) {
        return standardMapper.getStandardByType(type);
    }

    public List<Standard> getStandardByNum(String num) {
        return standardMapper.getStandardByNum(num);
    }
    public List<Standard> getStandardByContent(String content) {
        return standardMapper.getStandardByContent(content);
    }

    public List<Standard> getStandardByRange(String use_range) {
        return standardMapper.getStandardByRange(use_range);
    }

    public Standard getStandardById(String id) {
        return standardMapper.getStandardById(id);
    }

    public List<Standard> getStandardBySearch(String type, String name, String number) {
        return standardMapper.getStandardBySearch(type, name, number);
    }

}
