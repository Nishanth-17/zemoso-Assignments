package com.example.SpringApp.ServiceTest;

import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Repository.UserRepository;
import com.example.SpringApp.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Test
    public void getUsersTest(){
        when(userRepository.findAll()).thenReturn(Stream.of(
                new User(1,"Willey","Willey@mail.com", "989898989"),
                new User(2,"mark","mark@mail.com","1212121212"))
                .collect(Collectors.toList()));
        assertEquals(2,userService.getUsers().size());
    }
    @Test
    public void getUserByIdTest(){
        User user=new User(1,"Willey","willey@mail.com","12112212");
        when(userRepository.findById(user.getUserId())).thenReturn((Optional.of(user)));
        assertEquals(1,userService.getUserById(user.getUserId()).getUserId());
    }
    @Test
    public void saveUserTest(){
        User user=new User(1,"Willey","willey@mail.com","12112212");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.saveUser(user));
    }
    @Test
    public void deleteUserTest(){
        User user=new User(1,"Willey","willey@mail.com","12112212");
        userService.deleteUser(user.getUserId());
        verify(userRepository,times(1)).deleteById(user.getUserId());
    }

}
