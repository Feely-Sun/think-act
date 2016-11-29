package com.ithink.iact.pj2.web;

import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunzihan
 * @version $Id: Boot.java V 0.1 11/3/16 15:31 sunzihan EXP $
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class Application {

    @RequestMapping("/p1")
    @ResponseBody
    String home() {
        System.out.println("dfdfdfdffdfdf");
        return "Hello World!----->ddddd";
    }

    public static void main(String[] args) throws Exception {
       // SpringApplication.run(Application.class, args);

        System.out.println(UUID.randomUUID().toString());


    }

}