package com.telussuko_spring_jwt.demo.spring_security_jwt.service;

import com.telussuko_spring_jwt.demo.spring_security_jwt.dao.Userrepo;
import com.telussuko_spring_jwt.demo.spring_security_jwt.model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSerive {

    private final Userrepo userrepo;
    private final PasswordEncoder  encoder ;
    public UserSerive(Userrepo userrepo, PasswordEncoder encoder) {
        this.userrepo = userrepo;
        this.encoder = encoder;
    }
//private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); this is not recomeneded approcha creat it in config file like securityconfig

    public User register(User user){
        userrepo.findByUsername(user.getUsername()).ifPresent((existingUser)-> {throw new RuntimeException("USER ALreday existed with this" + user.getUsername());});
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("Password : " + user.getPassword());
        User save = userrepo.save(user);
        return save;

    }
}
