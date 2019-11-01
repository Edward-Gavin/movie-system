package com.example.stduentinfo.demo.config;


import com.example.stduentinfo.demo.component.LoginHandlerInterceptor;
import com.example.stduentinfo.demo.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
                registry.addViewController("/index").setViewName("index");
            }
        };
        return adapter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 不拦截的请求地址： "/checknode","/login","/register","/","/login.html"
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/blank_api","/chartjs_statistic",
//                "/base/cinema/insert", "/base/cinema/show","/base/cinema/search","/data_cinema","/data_machine",
//                "/documents/standard","/documents/operate_course","/documents/handbook","/documents/hand_details",
//                "/documents/operate_details","/documents/stand_details","/statistic_analysis","/question/question",
//                "/data_search", "/direction_chat","/error_search","/system/user",
//                "/main.html","/index","/calendar_manage","/task_search","/details","/details_error","/details_room");
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/ai/*","/analysis/*","/assets/*",
//                "base/*","/course/*","/documents/*","/question/*","/source/*","/system/*","/task/*");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/checknode","/register","/login","/static/**","/auth","/");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */
        registry.addResourceHandler("/images/**").addResourceLocations("file:/Users/edwardgavinwang/IdeaProjects/github/Spring-boot-mybatis/src/main/resources/static/images/");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MylocaleResolver();
    }
}
