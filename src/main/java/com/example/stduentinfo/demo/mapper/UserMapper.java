package com.example.stduentinfo.demo.mapper;


import com.example.stduentinfo.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 用户基本信息表
    @Select( "select * from user where username = #{username}" )
    User findOne(String username);

    @Select("select * from user")
    List<User> findAll();

    @Select( "select username,password from user where username=#{username} and password=#{password}" )
    User findByUsernameAndPassword(@Param( "username" ) String username ,
                                   @Param( "password" ) String password);

    @Select( "select username from user where username=#{username}" )
    String selectUsername(@Param ( "username" ) String username );


    // 用户注册功能
    @Insert( "insert into user(username,password) values(#{username},#{password})" )
    void save( @Param ( "username" ) String username ,
               @Param( "password" ) String password);


    //多字段更新，只需要在单字段后面用逗号分隔来书写就行
    @Update( "update user set phone=#{phone}, mail=#{mail}, qq=#{qq}, sex = #{sex}, name=#{name},state=#{state},role=#{role} where username=#{username}" )
    void update(@Param( "phone" ) String phone,
                @Param( "mail" ) String mail,
                @Param( "qq" ) String qq,
                @Param( "sex" ) String sex,
                @Param( "name" ) String name,
                @Param("state") char state,
                @Param("role") Integer role,
                @Param( "username" ) String username);


    // 系统管理员用户更改用户基本信息功能，包括权限及状态
    @Update( "update user set phone=#{phone}, password=#{password}, mail=#{mail}, qq=#{qq}, sex = #{sex}, name=#{name},state=#{state},role=#{role} where username=#{username}" )
    void updatePassword(@Param( "phone" ) String phone,
                @Param("password") String password,
                @Param( "mail" ) String mail,
                @Param( "qq" ) String qq,
                @Param( "sex" ) String sex,
                @Param( "name" ) String name,
                @Param("state") char state,
                @Param("role") Integer role,
                @Param( "username" ) String username);

    // 用户个人信息更新功能，实现更改密码，手机号，邮箱，QQ，性别，真实姓名等信息
    @Update("update user set phone=#{phone}, password=#{password}, mail=#{mail}, qq=#{qq}, sex = #{sex}, name=#{name}")
    void updateself(@Param( "phone" ) String phone,
                    @Param("password") String password,
                    @Param( "mail" ) String mail,
                    @Param( "qq" ) String qq,
                    @Param( "sex" ) String sex,
                    @Param( "name" ) String name,
                    @Param( "username" ) String username);
}
