package com.telussuko_spring_jwt.demo.spring_security_jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentContorller {

    private Object ArrayList;
    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"ram","cse"),
             new Student(43,"siva","ces")));
//with out csrf we cant work with post
    @GetMapping("csrf_tocken")
    public CsrfToken getcsrfTocken(HttpServletRequest request){
        return   (CsrfToken)request.getAttribute("_csrf");


    }

    @GetMapping("student")
    public  List<Student> getStudents(){
        return students;
    }
    @PostMapping("students")
    public void  addstudent(@RequestBody Student student){
        students.add(student);
    }


 }
