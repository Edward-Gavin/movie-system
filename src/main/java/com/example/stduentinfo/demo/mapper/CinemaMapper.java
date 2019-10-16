package com.example.stduentinfo.demo.mapper;


import com.example.stduentinfo.demo.entity.Cinema;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CinemaMapper {
    @Select( "select * from cinema where cinemaName = #{cinemaName}" )
    List<Cinema> findByCinemaName(String cinemaName);

    @Select( "select * from cinema " +
            "where province=#{province} and " +
            "city=#{city}")
    List<Cinema> findByPC(@Param( "province" ) String province,
                                 @Param("city") String city );


    @Select("SELECT * FROM cinema WHERE cinemaName=#{cinemaName} and " +
            "province=#{province} and " +
            "city=#{city} and " +
            "responsible=#{responsible}")
    @Results({
            @Result(property = "cinemaName", column = "cinemaName"),
            @Result(property = "province", column = "province"),
            @Result(property = "city", column = "city"),
            @Result(property = "responsible", column = "responsible")})
    List<Cinema> findById(String cinemaName, String province, String city, String responsible);

    @Insert( "insert into " +
            "cinema(cinemaName,province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber) " +
            "values" +
            "(#{cinemaName},#{province},#{city},#{address},#{responsible},#{responsiblePhone},#{manager},#{managerPhone},#{roomNumber})" )
    void save( @Param ( "cinemaName" ) String cinemaName ,
               @Param( "province" ) String province ,
               @Param( "city" ) String city,
               @Param("address") String address ,
               @Param( "responsible" ) String responsible,
               @Param( "responsiblePhone" ) String responsiblePhone,
               @Param("manager") String manager ,
               @Param( "managerPhone" ) String managerPhone,
               @Param( "roomNumber" ) String roomNumber);

}
