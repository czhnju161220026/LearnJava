package com.nju.icspa;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
/*
* Hello SpringBoot
* */

@Controller
@EnableAutoConfiguration
class MyController {
    @GetMapping("/")
    public String home() {
        return "question";
    }

    @GetMapping("/questionnaire")
    public String question() {
        return "question";
    }

    @GetMapping("/submit_question")
    public String submit() {
        //TODO: 提取问卷信息
        return "submitQuestion";
    }
}

@RestController
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(MyController.class,args);
    }
}


