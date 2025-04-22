package com.telussuko_spring_jwt.demo.spring_security_jwt.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private  String name;
    private  String course;

}
