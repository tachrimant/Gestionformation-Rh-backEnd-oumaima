package com.example.demo.zynerator.security.dao;

import com.example.demo.zynerator.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{
    User findByUsername(String username);
    int deleteByUsername(String username);
    User findByEmail(String email);
}
