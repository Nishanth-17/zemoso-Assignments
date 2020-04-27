package com.example.SpringApp.Service;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;

import java.util.List;

public interface ItemService {
    public List<Item> getItemsByUser(int theId);
    public Item addItems(Item item, User user);
    public void deleteItemById(Integer theId);
}
