package com.telussuko_spring_jwt.demo.spring_security_jwt.controller;

import com.telussuko_spring_jwt.demo.spring_security_jwt.model.User;
import com.telussuko_spring_jwt.demo.spring_security_jwt.service.UserSerive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth/api")
public class UserController
{
    UserSerive userSerive;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
         User saveusr = userSerive.register(user);
         return ResponseEntity.ok(saveusr);
    }


}
