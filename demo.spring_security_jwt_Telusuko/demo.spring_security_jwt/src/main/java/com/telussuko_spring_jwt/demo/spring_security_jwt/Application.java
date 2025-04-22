package com.telussuko_spring_jwt.demo.spring_security_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//not at created proper exception handling and errror messaging only basic auth registration created no role based authentication in this code
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
