package com.example.stduentinfo.demo.mapper;

import com.example.stduentinfo.demo.entity.Studentinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select( "select * from taskinfo where username = #{username}" )
    public List<Studentinfo> findByUsername(String username);

    @Select( "select username,password from taskinfo where username=#{username} and password=#{password}" )
    public Studentinfo findByUsernameAndPassword(@Param( "username" ) String username , @Param( "password" ) String password);

    @Insert( "insert into taskinfo(taskName,publicUser,status,startDate,endDate,reponsible) values(#{taskName},#{publicUser},#{status},#{startDate},#{endDate},#{reponsible})" )
    public void save( @Param ( "taskName" ) String username , @Param( "publicUser" ) String password , @Param( "status" ) String sex, @Param("startDate") String birthday , @Param( "endDate" ) String myself, @Param( "reponsible" ) String QQ);

    //多字段更新，只需要在单字段后面用逗号分隔来书写就行
    @Update( "update taskinfo set taskName = #{taskName},publicUser=#{publicUser}, status=#{status}, startDate=#{startDate}, endDate=#{endDated} where taskName=#{taskName}" )
    public void update(@Param( "taskName" ) String sex,
                       @Param( "publicUser" ) String QQ,
                       @Param( "status" ) String birthday,
                       @Param( "startDate" ) String myself,
                       @Param( "username" ) String username);
}
