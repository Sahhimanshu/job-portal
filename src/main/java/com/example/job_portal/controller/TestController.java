package com.example.job_portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    List<String> list = List.of("Himanshu","Sah");

    @GetMapping("/test")
    public List<String> test(){
        return list;
    }
}
