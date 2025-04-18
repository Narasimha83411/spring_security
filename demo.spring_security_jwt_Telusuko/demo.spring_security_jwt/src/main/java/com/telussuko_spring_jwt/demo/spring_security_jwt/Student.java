package com.telussuko_spring_jwt.demo.spring_security_jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private  String name;
    private  String course;

}
