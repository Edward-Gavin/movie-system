//package com.example.stduentinfo.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Author: Edward Gavin
// * @Create: 2019-11-01 11:59
// */
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * 配置忽略安全管理的路径，一般为资源文件例如css，js,IMG等
//     *
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/resources/static/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);  //注意！注意！注意！这个必须注释或者删除掉否则以下配置会受到默认spring security规则影响
//        http
//                .authorizeRequests()
//                // 允许所有的用户访问/login页面
//                .antMatchers("/login","/checknode").permitAll()
//                // 其他地址的访问都需要验证权限
//                .antMatchers("/index").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                //自定义登录页面的地址
////                .loginPage("/login")
////                //自定义登录表单提交地址（默认:/login）
////                .loginProcessingUrl("/logining")
////                .passwordParameter("password")//自定义登录密码的表单名称（默认password）
////                .usernameParameter("username")//自定义登录用户名的表单名称（默认username）
////                .defaultSuccessUrl("/index")//自定义登录成功后跳转的页面
////                .failureForwardUrl("/login")//自定义登录失败跳转的页面
//                .and()
//                .logout()
////                .invalidateHttpSession(true)//登出时候清除sessionion
////                .clearAuthentication(true)//登出时候清除认证信息
////                .logoutUrl("/logout")//登出表单的地址
////                .logoutSuccessUrl("/login")//登出成功后跳转页面
//                .and()
////                    .csrf().disable()//配置是否启用csrf,默认启用
//                .cors().disable().headers().frameOptions().sameOrigin();//解决iframe无法访问
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USERS").and()
//                .withUser("user").password("234567").roles("ADMIN");
//
//    }
//}
