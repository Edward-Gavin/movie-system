package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-01 15:42
 */

@Controller
@Slf4j
@RequestMapping("/ai")
public class AIController {

    @RequestMapping("/direction_chat")
    public String directionChat(){
        return "ai/direction_chat";
    }

}
