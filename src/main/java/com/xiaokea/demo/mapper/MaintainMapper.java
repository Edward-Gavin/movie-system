package com.xiaokea.demo.mapper;

import com.xiaokea.demo.entity.Maintain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MaintainMapper {

    @Select("Select id, name, type, brand, model  from maintain where name LIKE CONCAT(CONCAT('%', #{name}), '%');")
    List<Maintain> getMaintainByName(@Param( "name" ) String name);

    @Select("Select id, name, type, brand, model  from maintain where type LIKE CONCAT(CONCAT('%', #{type}), '%');")
    List<Maintain> getMaintainByType(@Param( "type" ) String type);

    @Select("Select id, name, type, brand, model  from maintain where brand LIKE CONCAT(CONCAT('%', #{brand}), '%');")
    List<Maintain> getMaintainByBrand(@Param( "brand" ) String brand);

    @Select("Select id, name, type, brand, model  from maintain where model LIKE CONCAT(CONCAT('%', #{model}), '%');")
    List<Maintain> getMaintainByModel(@Param( "model") String model);

}
