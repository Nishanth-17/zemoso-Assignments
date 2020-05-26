package com.example.springsecuritylogin.ServiceTest;

import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
        @Autowired
        private UserService userService;
        @MockBean
        private UserRepository userRepository;

        @Test
        public void findByUsernameTest(){
            User user=new User(1,"Willey","willey@mail.com","12112212");
            when(userRepository.findByUsername(user.getUsername())).thenReturn((Optional.of(user)));
            assertEquals(1,userService.findByUsername(user.getUsername()).getUsername());
        }
    @Test
    public void findByEmailTest(){
        User user=new User(1,"Willey","willey@mail.com","12112212");
        when(userRepository.findByEmail(user.getEmail())).thenReturn((Optional.of(user)));
        assertEquals(1,userService.findByEmail(user.getEmail()).getEmail());
    }
        @Test
        public void saveUserTest(){
         User user=new User(1,"Willey","willey@mail.com","12112212");
          when(userRepository.save(user)).thenReturn(user);
         assertEquals(user,userService.saveUser(user));
        }



    }

}
