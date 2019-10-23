package com.example.stduentinfo.demo.mapper;

import com.example.stduentinfo.demo.entity.Studentinfo;
import com.example.stduentinfo.demo.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select( "select * from task" )
    List<Task> findAll();

    @Select( "select username,password from task where username=#{username} and password=#{password}" )
    Studentinfo findByUsernameAndPassword(@Param( "username" ) String username ,
                                          @Param( "password" ) String password);

    @Insert( "insert into task(title, equipment, publish, detail, date, status, start, end,responsible) " +
            "values(#{title},#{equipment},#{publish},#{detail},#{date}, #{status},#{start},#{end},#{responsible})" )
    void save( @Param ( "title" ) String title ,
               @Param( "equipment" ) String equipment,
               @Param("publish") String publish,
               @Param("detail") String detail,
               @Param("date") String date,
               @Param("start") String start,
               @Param( "end" ) String end,
               @Param( "responsible" ) String responsible,
               @Param( "status" ) Integer status);

    //多字段更新，只需要在单字段后面用逗号分隔来书写就行
    @Update( "update taskinfo set taskName = #{taskName},publicUser=#{publicUser}, status=#{status}, startDate=#{startDate}, endDate=#{endDated} where taskName=#{taskName}" )
    public void update(@Param( "taskName" ) String sex,
                       @Param( "publicUser" ) String QQ,
                       @Param( "status" ) String birthday,
                       @Param( "startDate" ) String myself,
                       @Param( "username" ) String username);
}
