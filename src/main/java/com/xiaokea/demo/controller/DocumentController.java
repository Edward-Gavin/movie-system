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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        List<Standard> standardAll = standardService.getStandardAll();
        model.addAttribute("standards", standardAll);
        return "documents/standard";
    }

    @RequestMapping("/documents/standard/search")
    public String standardSearch(Model model, HttpServletRequest httpServletRequest) {
        String type = httpServletRequest.getParameter("type");
        String name = httpServletRequest.getParameter("name");
        String number = httpServletRequest.getParameter("number");

        // 支持按照设备的类型进行检索
        List<Standard> standards = standardService.getStandardBySearch(type, name, number);
        model.addAttribute("standards", standards);

        return "documents/standard";
    }

    @RequestMapping("/documents/operate_course")
    public String operateCourse(Model model) {
        List<Maintain> maintainAll = maintainService.getMaintainAll();
        model.addAttribute("maintains", maintainAll);
        return "documents/operate_course";
    }

    @RequestMapping("/documents/maintain/search")
    public String operateSearch(Model model, HttpServletRequest httpServletRequest) {
        String equ_type = httpServletRequest.getParameter("equ_type");
        String brand = httpServletRequest.getParameter("brand");
        String model1 = httpServletRequest.getParameter("model");
        String name = httpServletRequest.getParameter("name");

        // 支持按照设备的类型进行检索
        List<Maintain> maintains = maintainService.getMaintainBySearch(equ_type, brand, model1, name);
        model.addAttribute("maintains", maintains);

        return "documents/operate_course";
    }

    @RequestMapping("/documents/malfunction/search")
    public String handbookSearch(Model model, HttpServletRequest httpServletRequest) {
        String type = httpServletRequest.getParameter("equ_type");
        String error = httpServletRequest.getParameter("error");
        String brand = httpServletRequest.getParameter("brand");
        String model1 = httpServletRequest.getParameter("model");
        String number = httpServletRequest.getParameter("code");
        log.info(type);
        log.info(error);
        log.info(brand);
        log.info(model1);
        log.info(number);

        List<Malfunction> malfunctions = malfunctionService.getMalfunctionBySearch(error, type, brand, model1, number);
        log.info(malfunctions.toString());
        model.addAttribute("malfunctions", malfunctions);

        return "documents/handbook";
    }

    @RequestMapping("/documents/handbook")
    public String getHandbook(Model model) {
        List<Malfunction> malfunctionAll = malfunctionService.getMalfunctionAll();
        model.addAttribute("malfunctions", malfunctionAll);
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
        return "documents/search";
    }


    @RequestMapping(value = "/documents/standard/{standard}", method = RequestMethod.GET)
    public String standDetails(Model model, @PathVariable String standard) {
        Standard standard1 = standardService.getStandardById(standard);
        model.addAttribute("standard1", standard1);
        return "/documents/stand_details";
    }

    @RequestMapping(value = "/documents/maintain/{maintain}", method = RequestMethod.GET)
    public String maintainDetails(Model model, @PathVariable String maintain) {
        Maintain maintain1 = maintainService.getMaintainById(maintain);
        model.addAttribute("maintain", maintain1);
        return "/documents/operate_details";
    }

    @RequestMapping(value = "/documents/malfunction/{malfunction}", method = RequestMethod.GET)
    public String malfunctionDetails(Model model, @PathVariable String malfunction) {
        Malfunction malfunction1 = malfunctionService.getMalfunctionById(malfunction);
        model.addAttribute("malfunction", malfunction1);
        return "/documents/hand_details";
    }

}