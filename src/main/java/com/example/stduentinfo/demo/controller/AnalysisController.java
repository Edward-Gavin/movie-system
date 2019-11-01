package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-01 15:45
 */

@Controller
@Slf4j
@RequestMapping("/analysis")
public class AnalysisController {

    @RequestMapping("/chart_statistic")
    public String chartStatistic(){
        return "analysis/chart_statistic";
    }

    @RequestMapping("/float_analysis")
    public String floatAnalysis(){
        return "analysis/float_analysis";
    }

    @RequestMapping("/statistic_analysis")
    public String statisticAnalysis(){
        return "analysis/statistic_analysis";
    }

}
