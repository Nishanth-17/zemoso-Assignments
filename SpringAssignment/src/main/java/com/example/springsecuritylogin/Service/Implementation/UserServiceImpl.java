package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.Role;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Exception.UserNotFound;
import com.example.springsecuritylogin.Repository.RoleRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getUsers() {
        List<User> users=userRepository.findAll();
        users.remove(0);
        return users;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFound(id);
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Optional<Role> role=roleRepository.findById(2);
        Set<Role> roleSet=new HashSet<>();
        if(role.isPresent()) {
            roleSet.add(role.get());
        }
        user.setRoles(roleSet);
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
