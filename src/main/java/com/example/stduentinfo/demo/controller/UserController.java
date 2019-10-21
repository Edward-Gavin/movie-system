package com.example.stduentinfo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-18 20:49
 */

@Controller
@Slf4j
public class UserController {

    @RequestMapping(value = "/image/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("name")String name){
        String filepath="/image/";
        File file = new File(filepath+name);
        FileInputStream inputStream = null;
        byte[] bytes =null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }


}
