package com.bai1.controller;

import com.bai1.modal.Bmi;
import com.bai1.modal.Student;
import com.bai1.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Service service;

    @GetMapping("/random")
    public String getRandomChar(){
        return service.ranDomChar();
    }
    @GetMapping("/quote")
    public String getRandomList(){
        return service.ranDomInList();
    }
    @PostMapping("/bmi")
    public String bmi(@RequestBody Bmi bmi){
        float result=bmi.getWeight()/(bmi.getHeight()*bmi.getHeight());
        return String.valueOf(result);
    }

    @GetMapping("/student")
    public List<Student>listAll(){
        return service.listAll();
    }
    @PostMapping("/student")
    public String add(@RequestBody Student student){
       service.addStudent(student);
       return "add student success";
    }
}
