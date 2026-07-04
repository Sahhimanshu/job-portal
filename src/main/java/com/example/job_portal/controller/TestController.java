package com.example.job_portal.controller;

import com.example.job_portal.dto.UserDto;
import com.example.job_portal.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired private AuthenticationService authenticationService;
    List<String> list = List.of("Himanshu","Sah");

    @GetMapping("/test")
    public List<String> test(){
        return list;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto){
       return authenticationService.register(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return authenticationService.login(userDto);
    }
}
