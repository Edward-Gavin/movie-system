package com.example.stduentinfo.demo;

import com.example.stduentinfo.demo.service.CinemaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith (SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testCinemaSearch() {
        CinemaService cinemaService = null;

        cinemaService.findByAll("北京市", "朝阳区","劲松电影院", "张three");

    }

}
