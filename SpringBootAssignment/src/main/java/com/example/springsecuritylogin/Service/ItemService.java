package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.User;

import java.util.List;

public interface ItemService {
    List<Item> getItemsByUser(int id);

    Item addItems(Item item, User user);

    void deleteItemById(int id);
}