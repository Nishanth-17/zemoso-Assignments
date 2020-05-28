package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    User findByEmail(String email);
    User updateUser(User user);
}
