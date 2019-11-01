package com.xiaokea.demo.controller;

import com.xiaokea.demo.config.ImageConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-23 21:31
 */

@Controller
@Slf4j
public class UploadController {

    @Autowired
    ImageConfig imageConfig;

    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {

        if (file.isEmpty()) {
            System.out.println("文件为空");
        }

        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径 通过配置文件获取本地映射的绝对路径
        String filePath = imageConfig.getUploadPath();
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/images/" + fileName;
        model.addAttribute("filename", filename);

        return "file";
    }
}
