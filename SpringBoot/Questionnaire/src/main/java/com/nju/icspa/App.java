package com.nju.icspa;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
/*
* Hello SpringBoot
* */

@RestController
@EnableAutoConfiguration
public class App {
    @RequestMapping("/")
    String home() {
        return "Hello SpringBoot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}


