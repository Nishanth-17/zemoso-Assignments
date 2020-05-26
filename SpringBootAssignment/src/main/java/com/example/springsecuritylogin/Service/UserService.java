package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}
