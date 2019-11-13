package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.Cinema;
import com.xiaokea.demo.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-28 18:43
 */

@Controller
@Slf4j
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/show")
    public String showAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/show";
    }


    @RequestMapping("/search")
    public String searchAssets(Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        return "assets/search";
    }

    @RequestMapping("/insert")
    public String insertAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/insert";
    }

    @RequestMapping("/details")
    public String detailsAssets(HttpServletRequest httpServletRequest, Model model) {

        return "assets/details";
    }

    @RequestMapping("/details_room")
    public String detailsRoom(){
        return "assets/details_room";
    }

}
