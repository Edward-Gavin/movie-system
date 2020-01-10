package com.xiaokea.demo.mapper;

import com.xiaokea.demo.entity.Maintain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.applet.Main;

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

    @Select("Select * from maintain where id = #{id} ;")
    Maintain getMaintainById(@Param( "id") String id);

    @Select("Select id, name, type, brand, model  from maintain where type LIKE CONCAT(CONCAT('%', #{type}), '%')" +
            "and brand LIKE CONCAT(CONCAT('%', #{brand}), '%')" +
            "and model LIKE CONCAT(CONCAT('%', #{model}), '%')" +
            "and name LIKE CONCAT(CONCAT('%', #{name}), '%')")
    List<Maintain> getMaintainBySearch(@Param( "type") String type,
                                      @Param( "brand") String brand,
                                      @Param( "model") String model,
                                      @Param( "name") String name);
    @Select("Select * from maintain;")
    List<Maintain> getMaintainAll();

}
