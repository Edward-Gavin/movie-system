package com.xiaokea.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Edward Gavin
 * @Create: 2019-11-02 10:17
 */
@Controller
@Slf4j
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/chat")
    public String chat() {
        return "chat/chat";
    }
}
