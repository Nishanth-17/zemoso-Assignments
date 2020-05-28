package com.example.SpringApp.ServiceTest;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Repository.ItemRepository;
import com.example.SpringApp.Service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @MockBean
    private ItemRepository itemRepository;

    @Test
    public void getItemsByIdTest(){
        User user=new User(1,"Craig","Thompson","9090909090");
        Item item=new Item(1,"Martini Velvet");
        when(itemRepository.findById(item.getItemId())).thenReturn(Optional.of((item)));

        assertEquals(1,itemService.getItemsByUser(user.getUserId()).size());
    }

    @Test
    public void addItemsTest(){
        User user=new User(1,"Craig","Thompson","9090909090");
        Item item=new Item(1,"Martini Velvet");
        when(itemRepository.save(item)).thenReturn(item);
        assertEquals(item,itemService.addItems(item,user));
    }

    @Test
    public void deleteItemByIdTest(){
        User user=new User(1,"Craig","Thompson","9090909090");
        Item item=new Item(1,"Martini Velvet");
        itemService.deleteItemById(item.getItemId());
        Mockito.verify(itemRepository,Mockito.times(1))
                .deleteById(item.getItemId());
    }
}

