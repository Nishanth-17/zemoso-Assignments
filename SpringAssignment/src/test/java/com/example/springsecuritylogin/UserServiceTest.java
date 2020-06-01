package com.example.springsecuritylogin;

import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Exception.UserNotFound;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
        @Autowired
        private UserService userService;
        @MockBean
        private UserRepository userRepository;

        @Test
        public void getUsersTest(){
            List<User> users=new ArrayList<>();
            users.add(new User(1,"Willey","willey@gmail.com","1212121212"));
            when(userRepository.findAll()).thenReturn(users);
            assertEquals(users,userService.getUsers());
        }
        @Test
        public void getUserById(){
            User user=new User(1,"Willey","willey@mail.com","12112212");
            when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
            assertEquals(user,userService.getUserById(user.getId()));
            boolean thrown=false;
            try {
                userService.getUserById(2);
            }catch (UserNotFound e){
                thrown=true;
            }
            assertEquals(true,thrown);
        }
        @Test
        public void findByUsernameTest(){
            User user=new User(1,"Willey","willey@mail.com","12112212");
            when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
            assertEquals("Willey",userService.findByUsername(user.getUsername()).getUsername());
            assertEquals(null,userService.findByUsername("Don"));
        }
        @Test
        public void findByEmailTest(){
            User user=new User(1,"Willey","willey@mail.com","12112212");
            when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
            assertEquals("willey@mail.com",userService.findByEmail(user.getEmail()).getEmail());
        }
        @Test
        public void saveUserTest(){
            User user=new User(1,"Willey","willey@mail.com","12112212","password",null);
            userService.saveUser(user);
            Mockito.verify(userRepository, Mockito.times(1))
                .save(user);
        }
        @Test
        public void updateUserTest(){
            User user=new User(1,"Willey","willey@mail.com","12112212");
            when(userRepository.save(user)).thenReturn(user);
            assertEquals(user,userService.updateUser(user));
            assertNotNull(userService.updateUser(user));
        }
    }