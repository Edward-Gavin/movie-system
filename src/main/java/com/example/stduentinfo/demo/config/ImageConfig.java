package com.example.stduentinfo.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward Gavin
 * @Create: 2019-10-23 22:22
 */

@Component
@ConfigurationProperties(prefix = "image-config")
public class ImagesConfig {

    private String uploadPath;

    public String getImageUri() {
        return uploadPath;
    }

    public void setImageUri(String imageUri) {
        this.uploadPath = imageUri;
    }
}