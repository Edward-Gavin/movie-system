package com.example.stduentinfo.demo.controller;

import com.example.stduentinfo.demo.entity.User;
import com.example.stduentinfo.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author: Edward Gavin
 * @Create: 2019-10-18 20:49
 */

@Controller
@Slf4j
@RequestMapping("/system")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String getAllStu(Model model) {
        List<User> users = userService.findAllStu();
        model.addAttribute("users", users);
        return "system/user";
    }


    // 需要返回当前用户的详细信息，展现在前端页面中   ** 未完成 **  ---> finished
    @RequestMapping("/update{username}")
    public String updateUser(Model model, @RequestParam(value="username") String username) {
        User user = userService.findOne(username);
        log.info(user.toString());
        model.addAttribute("user", user);
        return "system/update";
    }


    // 修改界面提交还是有问题，处理中    ** 未完成 ** ---> finished
    @RequestMapping("/updating")
    public String updatingUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getParameter("username");
        String sex = httpServletRequest.getParameter("sex");
        String phone = httpServletRequest.getParameter("phone");
        String mail = httpServletRequest.getParameter("mail");
        String qq = httpServletRequest.getParameter("qq");
        String name = httpServletRequest.getParameter("name");
        String preState = httpServletRequest.getParameter("state");
        char state = preState.toCharArray()[0];
        String preRole = httpServletRequest.getParameter("role");
        Integer role = Integer.parseInt(preRole);

        userService.update(phone,mail,qq,sex,name,state, role, username);
        User user = userService.findOne(username);
        model.addAttribute("user", user);
        return "system/update";
    }

    @RequestMapping("/role")
    public String role() {
        return "system/role";
    }

    @RequestMapping("/self")
    public String selfUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getSession().getAttribute("username").toString();
        User user = userService.findOne(username);
        log.info(user.toString());
        model.addAttribute("user", user);
        return "system/self";
    }


    // 修改界面提交还是有问题，处理中……    ---> finished
    @RequestMapping("/selfing")
    public String selfingUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getParameter("username");
        String password1 = httpServletRequest.getParameter("password1");
        String sex = httpServletRequest.getParameter("sex");
        String phone = httpServletRequest.getParameter("phone");
        String mail = httpServletRequest.getParameter("mail");
        String qq = httpServletRequest.getParameter("qq");
        String name = httpServletRequest.getParameter("name");

        userService.updateself(phone, password1, mail, qq, sex, name, username);
        User user = userService.findOne(username);
        model.addAttribute("user", user);
        return "system/self";
    }

}
