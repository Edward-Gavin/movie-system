package com.example.stduentinfo.demo.mapper;


import com.example.stduentinfo.demo.entity.Cinema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CinemaMapper {
    @Select( "select * from cinema where cinemaName = #{cinemaName}" )
    public List<Cinema> findByCinemaName(String cinemaName);

    @Select( "select * from cinema " +
            "where cinemaName=#{cinemaName} and " +
            "province=#{province} and " +
            "city=#{city} and " +
            "responsible=#{responsible}" )
    public Cinema findByAllParam(@Param( "cinemaName" ) String cinemaName ,
                                 @Param( "province" ) String province,
                                 @Param("city") String city,
                                 @Param("responsible") String responsible);

}
