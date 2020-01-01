package com.xiaokea.demo.controller;

import com.xiaokea.demo.entity.Maintain;
import com.xiaokea.demo.entity.Malfunction;
import com.xiaokea.demo.entity.Standard;
import com.xiaokea.demo.service.MaintainService;
import com.xiaokea.demo.service.MalfunctionService;
import com.xiaokea.demo.service.StandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author: Edward Gavin
 * @Create: 2019-10-21 16:24
 */
@Controller
@Slf4j
public class DocumentController {

    @Autowired
    private StandardService standardService;



    @Autowired
    private MaintainService maintainService;

    @Autowired
    private MalfunctionService malfunctionService;


    @RequestMapping("/documents/standard")
    public String searchStandard(Model model) {


        return "documents/standard";
    }

    @RequestMapping("/documents/operate_course")
    public String operateCourse(Model model) {

        return "documents/operate_course";
    }

    @RequestMapping("/documents/handbook")
    public String getHandbook(Model model) {

        return "documents/handbook";
    }

    @RequestMapping("/documents/stand_details")
    public String getStandardDetails(Model model) {

        return "documents/stand_details";
    }

    @RequestMapping("/documents/operate_details")
    public String getOperateDetails(Model model) {

        return "documents/operate_details";
    }

    @RequestMapping("/documents/hand_details")
    public String getHandbookDetails(Model model) {

        return "documents/hand_details";
    }

    @RequestMapping("/documents/hand_details5180")
    public String getHandbookDetails5(Model model) {

        return "documents/hand_details5180";
    }

    @RequestMapping("/documents/search")
    public String getDecumentSearch(Model model, HttpServletRequest httpServletRequest) {
        return "documents/search";
    }

    @RequestMapping("/documents/searching")
    public String getSearch(Model model, HttpServletRequest httpServletRequest) {
        String standard = httpServletRequest.getParameter("standard");
        String maintain = httpServletRequest.getParameter("maintain");
        String malfunction = httpServletRequest.getParameter("malfunction");

        String field1 = httpServletRequest.getParameter("field1");
        String keywords1 = httpServletRequest.getParameter("keywords1");
        String relation1 = httpServletRequest.getParameter("relation1");
        String keywords2 = httpServletRequest.getParameter("keywords2");
        String method1 = httpServletRequest.getParameter("method1");

        String field2 = httpServletRequest.getParameter("field2");
        String keywords3 = httpServletRequest.getParameter("keywords3");
        String relation2 = httpServletRequest.getParameter("relation2");
        String keywords4 = httpServletRequest.getParameter("keywords4");
        String method2 = httpServletRequest.getParameter("method2");

        String field3 = httpServletRequest.getParameter("field3");
        String keywords5 = httpServletRequest.getParameter("keywords5");
        String relation3 = httpServletRequest.getParameter("relation3");
        String keywords6 = httpServletRequest.getParameter("keywords6");
        String method3 = httpServletRequest.getParameter("method3");

        String time = httpServletRequest.getParameter("time");

//        log.info(standard);
//        log.info(maintain);
//        log.info(malfunction);
//        log.info(field1);
//        log.info(keywords1);
//        log.info(relation1);
//        log.info(keywords2);
//        log.info(method1);
//        log.info(field2);
//        log.info(keywords3);
//        log.info(relation2);
//        log.info(keywords4);
//        log.info(method2);
//
//        log.info(time);

        if (standard != null){
            if (field1.equals("name1")) {
                List<Standard> standards = standardService.getStandardByName(keywords1);
                model.addAttribute("standards", standards);
            }
            if (field1.equals("type1")) {
                List<Standard> standards = standardService.getStandardByType(keywords1);
                model.addAttribute("standards", standards);
            }
            if (field1.equals("specification1")) {
                List<Standard> standards = standardService.getStandardByNum(keywords1);
                model.addAttribute("standards", standards);
            }
            if (field1.equals("model1")) {
                List<Standard> standards = standardService.getStandardByContent(keywords1);
                model.addAttribute("standards", standards);
            }
            if (field1.equals("level1")) {
                List<Standard> standards = standardService.getStandardByRange(keywords1);
                model.addAttribute("standards", standards);
            }

        }

        if (maintain != null){
            if(field2.equals("name2")){
                List<Maintain> maintains = maintainService.getMaintainByName(keywords3);
                model.addAttribute("maintains", maintains);
            }

            if(field2.equals("type2")){
                List<Maintain> maintains = maintainService.getMaintainByType(keywords3);
                model.addAttribute("maintains", maintains);
            }
            if(field2.equals("specification2")){
                List<Maintain> maintains = maintainService.getMaintainByBrand(keywords3);
                model.addAttribute("maintains", maintains);
            }
            if(field2.equals("model2")){
                List<Maintain> maintains = maintainService.getMaintainByModel(keywords3);
                model.addAttribute("maintains", maintains);
            }
        }

        if (malfunction!= null){
            if(field3.equals("name3")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByType(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
            if(field3.equals("type3")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByEquType(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
            if(field3.equals("specification3")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByBrand(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
            if(field3.equals("model3")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByModel(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
            if(field3.equals("model3")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByModel(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }

            if(field3.equals("code")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByCode(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }

            if(field3.equals("return_mg")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByReturnMg(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
            if(field3.equals("details")){
                List<Malfunction> malfunctions = malfunctionService.getMalfunctionByDetails(keywords5);
                model.addAttribute("malfunctions", malfunctions);
            }
        }
        model.addAttribute("standardss", standard);
        model.addAttribute("maintain", maintain);
        model.addAttribute("malfunction", malfunction);
        return "documents/search";
    }
}