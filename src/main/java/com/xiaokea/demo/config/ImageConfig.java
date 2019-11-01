package com.xiaokea.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-23 22:22
 */

@Component
@ConfigurationProperties(prefix = "image-config")
public class ImageConfig {

    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}