package com.xiaokea.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-13 19:28
 * 登录的拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         Object user =  request.getSession().getAttribute("username");
        if (user == null) {
            //未登录，返回登录页面
            request.setAttribute("information","您还没有登录，请先登录！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        } else {
            //登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

