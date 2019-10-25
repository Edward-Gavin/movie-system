package com.example.stduentinfo.demo.controller;

import com.example.stduentinfo.demo.entity.Studentinfo;
import com.example.stduentinfo.demo.entity.User;
import com.example.stduentinfo.demo.mapper.UserMapper;
import com.example.stduentinfo.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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

    //修改个人信息
//    @RequestMapping("/change{username}")
//    public String updateinfo(HttpServletRequest request, HttpServletResponse httpServletResponse,
//                             @RequestParam(value="username") String username, Map<String,Object> map){
//        log.info( username );
//        String sex = request.getParameter( "sex" );
//        String QQ = request.getParameter( "QQ" );
//        String birthday =request.getParameter( "birthday" );
//        String myself =request.getParameter( "myself" );
//
//        log.info( username );
//        httpServletResponse.setContentType( "text/html;charset=utf-8 ");
//        if(sex!=null&&QQ!=null&&birthday!=null&&myself!=null) { studentService.update( sex,QQ,birthday,myself,username);
//            PrintWriter out=null;
//            try {
//                out=httpServletResponse.getWriter();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            out.print( "<script type=\"text/javascript\">alert('修改信息成功！！')</script>" );
//            return "person";
//        }else {
//            map.put( "information","修改的信息内容不能为空");
//            return "changeinfo";
//        }
//    }
//
//    //    查看个人信息
//    @RequestMapping("/personinfo{username}")
//    public ModelAndView getPersonInfo(@RequestParam String username ){
//        List<Studentinfo> studentinfo = studentService.findByUsername( username );
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName( "personinfo" );
//        //获取列表中的元素（和用javaGUI 那个项目获取信息的方式一样，有个弊端就是太麻烦，目前正在讲究简便方法）
//        //thymleaf模板太复杂了，我这个菜鸟学起来好吃力
//        String Username = studentinfo.get(0).getUsername();
//        String Sex = studentinfo.get(0).getSex();
//        String Birthday = studentinfo.get(0).getBirthday();
//        String QQ = studentinfo.get(0).getQQ();
//        String Myself = studentinfo.get(0).getMyself();
//
//
//        mv.addObject( "Username",Username );
//        mv.addObject( "Sex",Sex );
//        mv.addObject( "Birthday",Birthday );
//        mv.addObject( "QQ",QQ  );
//        mv.addObject( "Myself",Myself  );
//
//        return mv;
//    }

    @RequestMapping("/user")
    public String getAllStu(Model model) {

        List<User> users = userService.findAllStu();

        model.addAttribute("users", users);
        return "system/user";
    }


    // 需要返回当前用户的详细信息，展现在前端页面中   ** 未完成 **
    @RequestMapping("/update")
    public String updateUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getSession().getAttribute("username").toString();
        User user = userService.findOne(username);
        log.info(user.toString());
        model.addAttribute("user", user);
        return "system/update";
    }


    // 修改界面提交还是有问题，处理中    ** 未完成 **
    @RequestMapping("/updating")
    public String updatingUser(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getParameter("username");
        String sex = httpServletRequest.getParameter("sex");
        log.info(sex);
        String phone = httpServletRequest.getParameter("phone");
        String mail = httpServletRequest.getParameter("mail");
        String qq = httpServletRequest.getParameter("qq");
        String name = httpServletRequest.getParameter("name");
        String preState = httpServletRequest.getParameter("state");
        char state = preState.toCharArray()[0];
        String preRole = httpServletRequest.getParameter("role");
        Integer role = Integer.parseInt(preRole);

        userService.update(phone,mail,qq,sex,name,state, role, username);
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


    // 修改界面提交还是有问题，处理中……    ** 未完成 **
    @RequestMapping("/selfing")
    public String selfingUser(HttpServletRequest httpServletRequest, Model model) {
        String username = httpServletRequest.getParameter("username");
        String password1 = httpServletRequest.getParameter("password1");
        String password2 = httpServletRequest.getParameter("password2");
        String sex = httpServletRequest.getParameter("sex");
        String phone = httpServletRequest.getParameter("phone");
        String mail = httpServletRequest.getParameter("mail");
        String qq = httpServletRequest.getParameter("qq");
        String name = httpServletRequest.getParameter("name");
        String preState = httpServletRequest.getParameter("state");
        char state = preState.toCharArray()[0];
        String preRole = httpServletRequest.getParameter("role");
        Integer role = Integer.parseInt(preRole);

        if (password1.equals(password2)) {
            model.addAttribute("password", "密码不一致");
        } else {
            userService.updatePass(phone, password1, mail,qq,sex,name,state, role, username);
        }
        return "system/self";
    }

}
