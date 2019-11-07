package com.xiaokea.demo.mapper;


import com.xiaokea.demo.entity.Cinema;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


// 指定操作影院表的Mapper

// 在启动文件中已经添加了自动扫描Mapper的配置
//@Mapper
@Repository
public interface CinemaMapper {
    @Select( "select * from cinema where cinemaName = #{cinemaName}" )
    List<Cinema> findByCinemaName(String cinemaName);

    @Select("select * from cinema")
    List<Cinema> findAll();

    @Select( "select * from cinema " +
            "where province=#{province} and " +
            "city=#{city}")
    List<Cinema> findByPC(@Param( "province" ) String province,
                                 @Param("city") String city );

    @Select("select * from cinema where id=#{id}")
    Cinema findById(@Param("id") Integer id);


    @Select( "select * from cinema " +
            "where province=#{province} and " +
            "city=#{city} and cinemaName=#{cinemaName}")
    List<Cinema> findByProvinceAndCityAndCName(@Param( "province" ) String province,
                                               @Param("city") String city,
                                               @Param("cinemaName") String cinemaName);

    @Select( "select * from cinema " +
            "where province=#{province} and " +
            "city=#{city} and responsible=#{responsible}")
    List<Cinema> findByProvinceAndCityAndResponsible(@Param( "province" ) String province,
                                               @Param("city") String city,
                                               @Param("responsible") String responsible);



    @Select("SELECT * FROM cinema WHERE cinemaName=#{cinemaName} and " +
            "province=#{province} and " +
            "city=#{city} and " +
            "responsible=#{responsible}")
    @Results({
            @Result(property = "cinemaName", column = "cinemaName"),
            @Result(property = "province", column = "province"),
            @Result(property = "city", column = "city"),
            @Result(property = "responsible", column = "responsible")})

    List<Cinema> findByCPCR(String cinemaName, String province, String city, String responsible);

    @Insert( "insert into " +
            "cinema(id, cinemaName,province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber) " +
            "values" +
            "(#{id}, #{cinemaName},#{province},#{city},#{address},#{responsible},#{responsiblePhone},#{manager},#{managerPhone},#{roomNumber})" )
    void save(@Param("id") Integer id,
              @Param ( "cinemaName" ) String cinemaName ,
               @Param( "province" ) String province ,
               @Param( "city" ) String city,
               @Param("address") String address ,
               @Param( "responsible" ) String responsible,
               @Param( "responsiblePhone" ) String responsiblePhone,
               @Param("manager") String manager ,
               @Param( "managerPhone" ) String managerPhone,
               @Param( "roomNumber" ) String roomNumber);


    @Update("update cinema set cinemaName=#{cinemaName}, province=#{province}, city=#{city}, address=#{address}," +
            "responsible=#{responsible}, responsiblePhone=#{responsiblePhone}, manager=#{manager}, " +
            "managerPhone=#{managerPhone}, roomNumber=#{roomNumber} where id=#{id}")
    void updateById(@Param("cinemaName") String cinemaName,
                    @Param("province") String province,
                    @Param("city") String city,
                    @Param("address") String address,
                    @Param("responsible") String responsible,
                    @Param("responsiblePhone") String responsiblePhone,
                    @Param("manager") String manager,
                    @Param("managerPhone") String managerPhone,
                    @Param("roomNumber") String roomNumber,
                    @Param("id") int id);

}
