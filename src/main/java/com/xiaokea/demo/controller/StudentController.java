package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.RegisterInfoYanzheng;
import com.xiaokea.demo.entity.User;
import com.xiaokea.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class StudentController {
    //验证码宽度，验证码高度
    private static int WIDTH = 60;
    private static int HEIGHT = 20;

    @Autowired
    private UserService userService;

    /**
     *  登录功能
     * @param httpServletRequest
     * @param session
     * @param httpServletResponse
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/auth")
    public String login( HttpServletRequest httpServletRequest,HttpSession session,HttpServletResponse httpServletResponse,Map<String,Object> map)throws Exception{
        String username = httpServletRequest.getParameter( "username" );
        String password = httpServletRequest.getParameter( "password" );
        String checknode = httpServletRequest.getParameter( "checknode" );
        String checknode2 = (String)httpServletRequest.getSession().getAttribute( "checknode" );
        log.info(checknode2);
        log.info(username);
        log.info(password);
        User user = userService.findByUsernameAndPassword(username, password);
        log.info(user.toString());

        //session.setAttribute( "username",username);

        if(!checknode.equals( checknode2 )){
            map.put( "checknode","验证码错误" );
            return "login";
        }
        else if (user != null){
            log.info("IP地址和端口号："+httpServletRequest.getRemoteAddr()+":"+ httpServletRequest.getRemotePort());
            httpServletResponse.setContentType("text/html;charset=utf-8");
            //将信息返回
            httpServletRequest.getSession().setAttribute("username", username);
            return "redirect:/index";
        }
        else
        {
            //两种方式一种直接显示，一种弹出窗口显示
            map.put( "information","登陆失败,请检查用户名和密码" );
            //httpServletResponse.setContentType("text/html;charset=utf-8");
            //PrintWriter out1 = httpServletResponse.getWriter();
            //out1.print( "<script type=\"text/javascript\">alert('登陆失败,请检查用户名和密码!!!')</script>" );
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String loginout(HttpServletRequest httpServletRequest){
        //将session对象移除
        httpServletRequest.getSession().removeAttribute( "username" );
        return "login";
    }

    //加入验证码功能
    @RequestMapping("/checknode")
    public void checkservlet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {

        HttpSession session = httpServletRequest.getSession();
        httpServletResponse.setContentType( "image/jpeg" );
        ServletOutputStream sos = httpServletResponse.getOutputStream();
        //设置浏览器不要缓存此图片
        httpServletResponse.setHeader( "Pragma","No-cache" );
        httpServletResponse.setHeader( "Cache-Control","no-cache" );
        httpServletResponse.setDateHeader( "Expires",0);
        //创建内存图像并获得其图形上下文
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB );
        Graphics g = image.getGraphics();
        //产生随机验证码
        char[] rands = generateChechCode();
        //产生图像
        drawBackground(g);
        drawRands(g,rands);
        //结束图像的绘制过程，完成图像
        g.dispose();
        //将图像输出到客户端
        ByteArrayOutputStream bos = new ByteArrayOutputStream(  );
        ImageIO.write( image,"JPEG",bos );
        byte[] buf =bos.toByteArray();
        httpServletResponse.setContentLength( buf.length );
        bos.writeTo( sos );
        bos.close();
        sos.close();
        //将当前验证码存入session中
        session.setAttribute( "checknode",new String(rands) );
    }
    //画布背景
    private void drawBackground( Graphics g ) {
        //画背景
        g.setColor( new Color( 0XDCDCDC ) );
        g.fillRect( 0,0,WIDTH,HEIGHT );
        //随机产生120个干扰点
        for (int i =0;i<120;i++){
            int x = (int)(Math.random()*WIDTH);
            int y = (int)(Math.random()*HEIGHT);
            int red = (int)(Math.random()*255);
            int green = (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            g.setColor( new Color( red,green,blue ) );
            g.drawOval( x,y,1,0 );
        }
    }

    //验证字符
    private void  drawRands(Graphics g,char[] rands){
        g.setColor( Color.BLACK );
        g.setFont( new Font( null,Font.ITALIC|Font.BOLD,18 ) );
        //在不同的高度上输出验证吗的每个字符
        g.drawString( ""+rands[0],1,17 );
        g.drawString( ""+rands[1],16,15 );
        g.drawString( ""+rands[2],31,18 );
        g.drawString( ""+rands[3],46,16 );
        System.out.println(rands);
    }
    //生成一个4字符的验证码
    private char[] generateChechCode() {
        //定义验证码的字符集
        String chars = "1234567890qwertyuioplkjhgfdsazxcvbnm";
        char[] rands = new char[4];
        for (int i = 0;i<4 ;i++){
            int rand = (int)(Math.random()*36);
            rands[i]=chars.charAt( rand );
        }
        return rands;
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //注册功能
    @RequestMapping("/registering")
    public String registering(HttpServletRequest httpServletRequest,Map<String,String> map ) throws IOException {
        String username = httpServletRequest.getParameter( "username" );
        String password = httpServletRequest.getParameter( "password" );
        String password1 =httpServletRequest.getParameter( "password1" );


        //获取注册验证信息
        RegisterInfoYanzheng registerInfoYanzheng = new RegisterInfoYanzheng();
        registerInfoYanzheng.setUsername(username);
        registerInfoYanzheng.setPassword(password);
        registerInfoYanzheng.setPassword1(password1);

        // 判断用户名是否被注册了
        if(username.equals(userService.selectUsername(username))){
            //PrintWriter out = httpServletResponse.getWriter();
            map.put( "register_information","用户名已注册" );
            // out.print( "<p style='color=red'>用户名已注册</p>" );
            return "register";
        }
        // 如果用户名没有被注册，检查输入的信息是否符合规范
        if (!registerInfoYanzheng.panduan()){
            httpServletRequest.setAttribute("registerInfoYanzheng",registerInfoYanzheng);
            map.put( "username", registerInfoYanzheng.getErrors().get("username"));
            map.put( "password", registerInfoYanzheng.getErrors().get("password") );
            map.put( "password1", registerInfoYanzheng.getErrors().get("password1") );
            return "register";
        }
        else{
            userService.save( username,password);
            //将信息返回
            //PrintWriter out = httpServletResponse.getWriter();
            //out.print( "<script type=\"text/javascript\">alert('注册成功,请您登录！！！')</script>" );
            map.put( "information","注册成功，请您登录！" );
            return "login";
        }
    }
}
