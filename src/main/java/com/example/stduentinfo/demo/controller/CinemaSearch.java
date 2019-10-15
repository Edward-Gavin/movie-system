package com.example.stduentinfo.demo.controller;

import com.example.stduentinfo.demo.entity.Cinema;
import com.example.stduentinfo.demo.service.CinemaService;
import com.sun.deploy.net.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-15 15:02
 */
@Controller
@Slf4j
public class CinemaSearch {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Cinema cinemaSearch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map<String,String> map){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("cinemaDetails");
        String cinemaName = httpServletRequest.getParameter("cinemaName");
        String province = httpServletRequest.getParameter("province");
        String city = httpServletRequest.getParameter("city");
        String responsible = httpServletRequest.getParameter("responsible");

        Cinema cinema = cinemaService.findByAll(cinemaName, province, city, responsible);
        log.info(cinema.toString());
        log.info(cinema.getCinemaName());
        log.info(cinema.getPrivence());
//        modelAndView.addObject(cinema);
//        return modelAndView;
        return cinema;
    }
}
