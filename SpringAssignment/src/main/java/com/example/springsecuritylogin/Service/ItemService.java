package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Float> getTotalList(List<Item> items);
    List<Integer> getQuantityList(List<Item> items);
    Float getCartTotal(List<Item> items);
    List<Item> getItemsByUser(int id);
    Item addItems(Item item, User user, int itemStoreId);
    void deleteItemById(int id,int uid);
}