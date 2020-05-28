package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user= userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findByEmail(String email){
        User user=userRepository.findByEmail(email);
        return user;
    }

}
