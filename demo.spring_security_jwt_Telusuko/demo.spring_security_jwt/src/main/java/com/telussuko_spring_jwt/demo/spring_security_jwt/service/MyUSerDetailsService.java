package com.telussuko_spring_jwt.demo.spring_security_jwt.service;

import com.telussuko_spring_jwt.demo.spring_security_jwt.dao.Userrepo;
import com.telussuko_spring_jwt.demo.spring_security_jwt.model.User;
import com.telussuko_spring_jwt.demo.spring_security_jwt.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUSerDetailsService implements UserDetailsService {
    //step4
    @Autowired
     private Userrepo repo;


    // here parameter is ussername how will io get throw repository
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username).orElseThrow(()->new RuntimeException("USER NOT FOUND WITH THIS USERNAME" + username));

//        if(user == null){
//            System.out.println("User 404");
//            throw new UsernameNotFoundException("User 404");
//        }
        // if user is present then we need return user but insted of user we need to retrun userdetails is an inter face how can we retrun object for interface   so creating userpricipal
        return new UserPrincipal(user);
    }
}
