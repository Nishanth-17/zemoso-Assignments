package com.example.SpringApp.Service.Implementation;

import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Repository.UserRepository;
import com.example.SpringApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers(){
        List<User> userList=userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new RuntimeException("User not found");
        }
        return user;
    }

    @Override
    public User saveUser(User user){
        User newUser=userRepository.save(user);
        return newUser;
    }

    @Override
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
