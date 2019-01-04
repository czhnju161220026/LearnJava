package com.nju.icspa;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public String submit(HttpServletRequest request) {
        //TODO: 提取问卷信息
        String id = request.getParameter("id");
        String sex = request.getParameter("sex");
        String basis = request.getParameter("basis");
        String d3_2 = request.getParameter("difficulty3_2");
        String t3_2 = request.getParameter("time_press3_2");
        String d3_3 = request.getParameter("difficulty3_3");
        String t3_3 = request.getParameter("time_press3_3");
        String d4_1 = request.getParameter("difficulty4_1");
        String t4_1 = request.getParameter("time_press4_1");
        String d4_2 = request.getParameter("difficulty4_2");
        String t4_2 = request.getParameter("time_press4_2");
        String d4_3 = request.getParameter("difficulty4_3");
        String t4_3 = request.getParameter("time_press4_3");
        System.out.println(id+" "+sex);
        try{
            BufferedWriter fout = new BufferedWriter(new FileWriter(new File("answer"+id+".txt")));
            if(id == null ||id.length() == 0) {
                fout.write("匿名提交");
            }
            else {
                fout.write(id);
            }

            fout.newLine();
            fout.write(sex);
            fout.newLine();
            fout.write("basis: "+basis);
            fout.newLine();
            fout.write("difficulty3-2: "+d3_2);fout.newLine();
            fout.write("difficulty3-3: "+d3_2);fout.newLine();
            fout.write("difficulty4-1: "+d4_1);fout.newLine();
            fout.write("difficulty4-2: "+d4_2);fout.newLine();
            fout.write("difficulty4-3: "+d4_3);fout.newLine();
            fout.write("time_press3-2: "+t3_2);fout.newLine();
            fout.write("time_press3-3: "+t3_3);fout.newLine();
            fout.write("time_press4-1: "+t4_1);fout.newLine();
            fout.write("time_press4-2: "+t4_2);fout.newLine();
            fout.write("time_press4-3: "+t4_3);fout.newLine();
            fout.flush();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

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


