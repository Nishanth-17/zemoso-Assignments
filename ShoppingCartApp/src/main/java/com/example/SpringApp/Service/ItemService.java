package com.example.SpringApp.Service;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;

import java.util.List;

public interface ItemService {
     List<Item> getItemsByUser(int id);
     Item addItems(Item item, User user);
     void deleteItemById(int id);
}
