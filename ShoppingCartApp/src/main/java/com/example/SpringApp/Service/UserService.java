package com.example.SpringApp.Service;

import com.example.SpringApp.Entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User getUserById(int theId);
    public User saveUser(User user);
    public void deleteUser(int theId);
}

