package com.telussuko_spring_jwt.demo.spring_security_jwt.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String Hello(HttpServletRequest req){
        return "hello world" + req.getSession().getId();
    }
    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "telusuko"+ request.getSession().getId();
    }


}
