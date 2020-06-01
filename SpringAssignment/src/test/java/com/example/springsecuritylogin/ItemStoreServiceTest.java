package com.example.springsecuritylogin;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Exception.ItemNotFound;
import com.example.springsecuritylogin.Repository.ItemStoreRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.ItemStoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemStoreServiceTest {
    @Autowired
    private ItemStoreService itemStoreService;
    @MockBean
    private ItemStoreRepository itemStoreRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getItemsTest(){
        List<ItemStore> itemStores=new ArrayList<>();
        itemStores.add(new ItemStore(1,"Bottle",Float.valueOf(200),"Tupperware"));
        when(itemStoreRepository.findAll()).thenReturn(itemStores);
        assertEquals(1,itemStoreService.getItems().size());
        assertNotNull(itemStoreService.getItems());
    }

    @Test
    public void  getItemByIdTest() {
        ItemStore itemStore=new ItemStore(1,"Bottle",Float.valueOf(200),"Tupperware");
        when(itemStoreRepository.findById(1)).thenReturn(Optional.of(itemStore));
        assertEquals("Bottle",itemStoreService.getItemById(1).getItemName());
        assertNotEquals("Shirt",itemStoreService.getItemById(1).getItemName());
        boolean thrown=false;
        try{
            itemStoreService.getItemById(2);
        }
        catch (ItemNotFound exc){
            thrown=true;
        }
        assertEquals(true,thrown);
    }

    @Test
    public void saveItemTest(){
        ItemStore itemStore=new ItemStore(1,"Bottle",Float.valueOf(200),"Tupperware");
        when(itemStoreRepository.save(itemStore)).thenReturn(itemStore);
        assertEquals("Bottle",itemStoreService.saveItem(itemStore).getItemName());
        assertNotNull(itemStoreService.saveItem(itemStore));
    }

    @Test
    public void getItemStoreByUserTest() {
        User user = new User(1, "Craig", "Thompson", "9090909090");
        ItemStore itemstore = new ItemStore(1, "Bottle", Float.valueOf(35000), "LG");
        Item itemNew = new Item(1, 2, Float.valueOf(2000), user, itemstore);
        when(itemStoreRepository.findById(1)).thenReturn(Optional.of(itemstore));
        assertNotNull(itemStoreService.getItemStoreByUser(1));
    }

    @Test
    public void compareItemNamesTest(){
        List<Item> items=new ArrayList<>();
        User user = new User(1, "Craig", "Thompson", "9090909090");
        ItemStore itemstore = new ItemStore(1, "Bottle", Float.valueOf(35000), "LG");
        Item itemNew = new Item(1, 2, Float.valueOf(2000), user, itemstore);
        items.add(itemNew);
        when(itemStoreRepository.findById(1)).thenReturn(Optional.of(itemstore));
        assertEquals(true,itemStoreService.compareItemNames(items,1));
        assertNotEquals(false,itemStoreService.compareItemNames(items,1));
    }
    @Test
    public void deleteItemByIdTest(){
        ItemStore itemstore = new ItemStore(1, "Bottle", Float.valueOf(35000), "LG");
            itemStoreService.deleteItemById(itemstore.getId());
                Mockito.verify(itemStoreRepository, Mockito.times(1))
                        .deleteById(itemstore.getId());
            }
}

