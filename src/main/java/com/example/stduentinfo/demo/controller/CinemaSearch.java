package com.example.stduentinfo.demo.controller;

import com.example.stduentinfo.demo.entity.Cinema;
import com.example.stduentinfo.demo.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * @Author: Edward Gavin
 * @Create: 2019-10-15 15:02
 */
@Controller
@Slf4j
@RequestMapping("/base/cinema")
public class CinemaSearch {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/search")
    public String cinemaSearch(){
        return "base/cinema/search";
    }

    @RequestMapping("/show")
    public String cinemaSearch(HttpServletRequest httpServletRequest, Model model){
        String cinemaName = httpServletRequest.getParameter("cinemaName");
        String province = httpServletRequest.getParameter("province");
        String city = httpServletRequest.getParameter("city");
        String responsible = httpServletRequest.getParameter("responsible");

        if (cinemaName.equals("") && responsible.equals("")) {
            List<Cinema> cinemas = cinemaService.findByProvinceAndCity(province, city);
            for (Cinema cinema : cinemas) {
                log.info(cinema.toString());
            }
            model.addAttribute("cinemas", cinemas);
        }else if(!cinemaName.equals("")){
            List<Cinema> cinemas = cinemaService.findByPCN(province, city, cinemaName);
            for (Cinema cinema : cinemas) {
                log.info(cinema.toString());
            }
            model.addAttribute("cinemas", cinemas);
        }else if(!responsible.equals("")){
            List<Cinema> cinemas = cinemaService.findByPCR(province, city, responsible);
            for (Cinema cinema : cinemas) {
                log.info(cinema.toString());
            }
            model.addAttribute("cinemas", cinemas);
        }else{
            List<Cinema> cinemas = cinemaService.find(cinemaName, province, city, responsible);
            for (Cinema cinema : cinemas) {
                log.info(cinema.toString());
            }
            model.addAttribute("cinemas", cinemas);
        }
        return "base/cinema/show";
    }

    @RequestMapping("/insert")
    public String cinemaInsert(HttpServletRequest httpServletRequest, Model model) {
        return "base/cinema/insert";
    }
    @RequestMapping("/inserting")
    public String cinemaInserting(HttpServletRequest httpServletRequest, Map<String,String> map) {
        String cid = httpServletRequest.getParameter("id");
        log.info(cid);
        int id = Integer.parseInt(cid);
        String cinemaName = httpServletRequest.getParameter("cinemaName");
        String province = httpServletRequest.getParameter("province");
        String city = httpServletRequest.getParameter("city");
        String address = httpServletRequest.getParameter("address");
        String responsible = httpServletRequest.getParameter("responsible");
        String responsiblePhone = httpServletRequest.getParameter("responsiblePhone");
        String manager = httpServletRequest.getParameter("manager");
        String managerPhone = httpServletRequest.getParameter("managerPhone");
        String roomNumber = httpServletRequest.getParameter("roomNumber");

        try {
            cinemaService.saveCinema(id, cinemaName, province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber);
            map.put("Info", "影院信息添加成功！");
            return "base/cinema/insert";
        } catch (Exception e) {
            log.info(e.toString());
            map.put("Info", "影院信息添加失败，请查看添加信息！");
            return "base/cinema/insert";
        }
    }

    @RequestMapping("/update")
    public String cinemaUpdate(@RequestParam(value="id") int id, Model model) {
        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);
        return "base/cinema/update";
    }

    @RequestMapping("/updating")
    public String cinemaUpdating(@RequestParam(value="id") int id, HttpServletRequest httpServletRequest, Model model) {
        String cinemaName = httpServletRequest.getParameter("cinemaName");
        String province = httpServletRequest.getParameter("province");
        String city = httpServletRequest.getParameter("city");
        String address = httpServletRequest.getParameter("address");
        String responsible = httpServletRequest.getParameter("responsible");
        String responsiblePhone = httpServletRequest.getParameter("responsiblePhone");
        String manager = httpServletRequest.getParameter("manager");
        String managerPhone = httpServletRequest.getParameter("managerPhone");
        String roomNumber = httpServletRequest.getParameter("roomNumber");

        cinemaService.updateById(cinemaName, province, city, address, responsible, responsiblePhone, manager, managerPhone, roomNumber, id);
        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);
        return "base/cinema/update";
    }

    @RequestMapping("/details")
    public String details(){
        return "base/cinema/details";
    }

    @RequestMapping("/details_room")
    public String detailsRoom(){
        return "base/cinema/details_room";
    }
}
