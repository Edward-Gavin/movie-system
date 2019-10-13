package com.example.stduentinfo.demo.config;


import com.example.stduentinfo.demo.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
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
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("login.html").setViewName("login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MylocaleResolver();
    }
}
