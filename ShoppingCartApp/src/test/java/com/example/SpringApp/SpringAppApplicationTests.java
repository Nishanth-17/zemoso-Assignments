package com.example.SpringApp;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Repository.ItemRepository;
import com.example.SpringApp.Repository.UserRepository;
import com.example.SpringApp.Service.ItemService;
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
class SpringAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
