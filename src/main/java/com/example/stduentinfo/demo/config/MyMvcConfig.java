package com.example.stduentinfo.demo.config;


import com.example.stduentinfo.demo.component.LoginHandlerInterceptor;
import com.example.stduentinfo.demo.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-13 14:47
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/abc").setViewName("404");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("index");
                registry.addViewController("/task_search").setViewName("task_search");
            }
        };
        return adapter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 不拦截的请求地址： "/checknode","/login","/register","/","/login.html"
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/blank_api","/chartjs_statistic",
                "/base/cinema/insert", "/base/cinema/show","/base/cinema/search","/data_cinema","/data_machine",
                "/documents/standard","/documents/operate_course","/documents/handbook","/documents/hand_details",
                "/documents/operate_details","/documents/stand_details",
                "/data_search", "/direction_chat","/error_search",
                "/main.html","/index","/calendar_manage","/task_search","/details","/details_error","/details_room");
        super.addInterceptors(registry);
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MylocaleResolver();
    }
}
