package com.xiaokea.demo.mapper;

import com.xiaokea.demo.entity.Malfunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MalfunctionMapper {
    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where type LIKE CONCAT(CONCAT('%', #{type}), '%');")
    List<Malfunction> getMalfunctionByType(@Param( "type" ) String type);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where equ_type LIKE CONCAT(CONCAT('%', #{equ_type}), '%');")
    List<Malfunction> getMalfunctionByEquType(@Param( "equ_type" ) String equ_type);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where brand LIKE CONCAT(CONCAT('%', #{brand}), '%');")
    List<Malfunction> getMalfunctionByBrand(@Param( "brand" ) String brand);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where model LIKE CONCAT(CONCAT('%', #{model}), '%');")
    List<Malfunction> getMalfunctionByModel(@Param( "model" ) String model);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where code LIKE CONCAT(CONCAT('%', #{code}), '%');")
    List<Malfunction> getMalfunctionByCode(@Param( "code" ) String code);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where return_mg LIKE CONCAT(CONCAT('%', #{return_mg}), '%');")
    List<Malfunction> getMalfunctionByReturnMg(@Param( "return_mg" ) String return_mg);

    @Select("Select id, type, equ_type, brand, model, code, return_mg,details from malfunction where details LIKE CONCAT(CONCAT('%', #{details}), '%');")
    List<Malfunction> getMalfunctionByDetails(@Param( "details" ) String details);

}
