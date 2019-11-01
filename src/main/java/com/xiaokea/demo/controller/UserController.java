package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.User;
import com.xiaokea.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

    /**
     * 获取用户列表页
     * @param model
     * @return
     */
    @RequestMapping("/user")
    public String getAllStu(Model model) {
        List<User> users = userService.findAllStu();
        model.addAttribute("users", users);
        return "system/user";
    }

    /**
     * 更新当前用户信息；添加model视图；返回渲染的更新页面
     * @param model
     * @param username
     * @return
     */
    @RequestMapping(value = "/update/{username}", method = RequestMethod.GET)
    public String updateUser(Model model, @PathVariable String username) {
        User user = userService.findOne(username);
        log.info(user.toString());
        model.addAttribute("user", user);
        return "system/update";
    }


    /**
     * 管理员更新用户信息；添加model视图；返回渲染的更新页面
     * @param user1
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping(value = "/updating", method = RequestMethod.POST)
    public String updatingUser(User user1, HttpServletRequest httpServletRequest, Model model) {
        log.info(user1.toString());
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

    /**
     * 用户修改个人信息页面
     * 通过使用对象来直接获取参数，这里注意需要注意的是，对象的属性应该和提交表单的name名是一致的。
     * @param users
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping(value = "/selfing", method = RequestMethod.POST)
    public String selfingUser(User users, HttpServletRequest httpServletRequest, Model model) {
        log.info(users.toString());
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


    /**
     * 管理员操作删除用户
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String deleteUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getParameter("username");
        userService.deleteUser(username);
        List<User> users = userService.findAllStu();
        model.addAttribute("users", users);
        return "system/user";
    }

    /**
     * 访问接口页
     * @return
     */
    @RequestMapping("/blank_api")
    public String blankApi(){
        return "system/blank_api";
    }

}
