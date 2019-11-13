package com.xiaokea.demo;

import com.xiaokea.demo.config.ImageConfig;
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
        System.out.println(System.getProperties());
    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello thread");
        }
    }
    @Test
    public void testThread() {
        MyThread thread = new MyThread();
        thread.start();
    }


    @Test
    public void testThreadTwo() {
        Thread thread = new Thread(){
            public void run() {
                System.out.println("abc");
            }
        };

        thread.start();
    }


    public class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println("runnable running ");
        }
    }

    @Test
    public void testRunnable() {
        MyRunable myRunable = new MyRunable();
        Thread thread = new Thread(myRunable, "Thread-1");

        thread.start();
    }
}

