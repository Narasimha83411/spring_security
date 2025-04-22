package com.telussuko_spring_jwt.demo.spring_security_jwt.dao;

import com.telussuko_spring_jwt.demo.spring_security_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
  Optional<User>  findByUsername(String username);

}
