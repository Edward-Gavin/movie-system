package com.example.stduentinfo.demo;

import com.example.stduentinfo.demo.config.ImageConfig;
import com.example.stduentinfo.demo.service.CinemaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith (SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ImageConfig imagesConfig;

    @Test
    public void contextLoads() {
        System.out.println(imagesConfig.getUploadPath());
    }

}
