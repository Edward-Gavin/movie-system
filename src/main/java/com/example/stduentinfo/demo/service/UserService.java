package com.example.stduentinfo.demo.service;

import com.example.stduentinfo.demo.entity.User;
import com.example.stduentinfo.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-24 21:28
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    //注册功能
    public void save( String username, String password){
        userMapper.save( username, password);
    }

    //登陆功能（通过账号和密码查询数据库进行登陆）
    public User findByUsernameAndPassword(String username, String password){
        return userMapper.findByUsernameAndPassword( username,password );
    }

    //查询用户信息功能（通过用户名查询学生所有信息）
    public User findOne(String username){
        return userMapper.findOne( username );
    }

    //用户修改信息功能
    public void update(String phone,String mail,String qq,String sex, String name, char state, Integer role, String username){
        userMapper.update(phone, mail, qq, sex, name, state, role, username);
    }

    //修改用户密码等信息功能
    public void updatePass(String phone, String password, String mail,String qq,String sex, String name, char state, Integer role, String username){
        userMapper.updatePassword(phone, password, mail, qq, sex, name, state, role, username);
    }

    //注册验证用户名是否重复
    public String selectUsername(String username){
        return userMapper.selectUsername( username );
    }

    public List<User> findAllStu() {
        return userMapper.findAll();
    }

    // 用户修改个人信息功能
    public void updateself(String phone, String password, String mail,String qq,String sex, String name, String username){
        userMapper.updateself(phone, password, mail, qq, sex, name, username);
    }

    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }
}
