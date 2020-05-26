package com.example.springsecuritylogin.Repository;

import com.example.springsecuritylogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);
    User findByEmail(String email);
}
