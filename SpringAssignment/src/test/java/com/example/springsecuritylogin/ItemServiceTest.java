package com.example.springsecuritylogin;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.ItemRepository;
import com.example.springsecuritylogin.Repository.ItemStoreRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.ItemService;
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
    public class ItemServiceTest {

        @Autowired
        private ItemService itemService;
        @MockBean
        private UserRepository userRepository;
        @MockBean
        private ItemRepository itemRepository;
        @MockBean
        private ItemStoreRepository itemStoreRepository;



        @Test
        public void addItemsTest() {
            User user = new User(1, "Craig", "Thompson", "9090909090");
            Item item = new Item(1, 2, Float.valueOf(2000), user);
            ItemStore itemStore = new ItemStore(1, "Bottle", Float.valueOf(35000), "LG");
            item.setUser(user);
            item.setItemStore(itemStore);
            when(itemRepository.save(item)).thenReturn(item);
            assertEquals(item, itemService.addItems(item, user, 1));
            assertNotNull(itemService.addItems(item,user,2));
        }

        @Test
        public void getItemsByUserTest() {
            User user = new User(1, "Craig", "Thompson", "9090909090");
            List<Item> items = new ArrayList<>();
            Item item=new Item(1, 2, Float.valueOf(2000), user);
            item.setUser(user);
            items.add(item);
            when(userRepository.findById(1)).thenReturn(Optional.of(user));
            assertNull(itemService.getItemsByUser(user.getId()));
        }

        @Test
        public void deleteItemByIdTest() {
            User user = new User(1, "Craig", "Thompson", "9090909090");
            Item item = new Item(1, 2, Float.valueOf(2000), user);
            ItemStore itemstore = new ItemStore(1, "Bottle", Float.valueOf(35000), "LG");
            Optional<ItemStore> itemStore = itemStoreRepository.findById(1);
            if (itemStore.isPresent()) {
                List<Item> items = itemStore.get().getItems();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getUser().getId() == user.getId()) {
                        itemRepository.deleteById(items.get(i).getId());
                    }
                    itemService.deleteItemById(item.getId(), itemstore.getId());
                    Mockito.verify(itemRepository, Mockito.times(1))
                            .deleteById(item.getId());
                }
            }
        }
        @Test
        public void getTotalListTest(){
            List<Item> items=new ArrayList<>();
            List<Float> totalList=new ArrayList<>();
            items.add(new Item(1,1,Float.valueOf(2000)));
            totalList.add(items.get(0).getTotal());
            assertEquals(totalList,itemService.getTotalList(items));
            assertNotEquals(2,itemService.getTotalList(items).size());
        }

        @Test
        public void getQuantityListTest(){
            List<Item> items=new ArrayList<>();
            List<Integer> quantitylist=new ArrayList<>();
            items.add(new Item(1,1,Float.valueOf(2000)));
            quantitylist.add(items.get(0).getQuantity());
            assertEquals(quantitylist,itemService.getQuantityList(items));
            assertNotEquals(2,itemService.getQuantityList(items).size());
        }

        @Test
        public void getCartTotalTest(){
            List<Item> items=new ArrayList<>();
            Float cartTotal;
            items.add(new Item(1,1,Float.valueOf(2000)));
            cartTotal=items.get(0).getTotal();
            assertEquals(cartTotal,itemService.getCartTotal(items));
            assertNotEquals(Float.valueOf(1000),itemService.getCartTotal(items));
        }
    }