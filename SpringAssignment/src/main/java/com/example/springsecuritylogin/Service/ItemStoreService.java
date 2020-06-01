package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;

import java.util.List;
import java.util.Optional;

public interface ItemStoreService {
    List<ItemStore> getItems();
    ItemStore getItemById(int id);
    ItemStore saveItem(ItemStore itemStore);
    List<ItemStore> getItemStoreByUser(int id);
    boolean compareItemNames(List<Item> items, int itemStoreId);
    void deleteItemById(int id);
}
