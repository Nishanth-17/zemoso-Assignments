package com.example.SpringApp.Service;

import com.example.SpringApp.Entity.User;

import java.util.List;

  public interface UserService {
      List<User> getUsers();
      User getUserById(int id);
      User saveUser(User user);
      void deleteUser(int id);
}

