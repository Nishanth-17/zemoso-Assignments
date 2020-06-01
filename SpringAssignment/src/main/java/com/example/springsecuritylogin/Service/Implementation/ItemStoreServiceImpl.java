package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Exception.ItemNotFound;
import com.example.springsecuritylogin.Repository.ItemStoreRepository;
import com.example.springsecuritylogin.Repository.RatingRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.ItemStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemStoreServiceImpl implements ItemStoreService {

    @Autowired
    private ItemStoreRepository itemStoreRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ItemStore> getItems() {
        List<ItemStore> itemStores = itemStoreRepository.findAll();
        return itemStores;
    }

    @Override
    public ItemStore getItemById(int id) {
        Optional<ItemStore> itemStore = itemStoreRepository.findById(id);
        if(!itemStore.isPresent()){
            throw new ItemNotFound(id);
        }
        return itemStore.get();
    }

    @Override
    public ItemStore saveItem(ItemStore itemstore) {
        return itemStoreRepository.save(itemstore);
    }

    @Override
    public List<ItemStore> getItemStoreByUser(int id) {
        List<Item> items = new ArrayList<>();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            items = user.get().getItems();
        }
        List<ItemStore> itemsList = new ArrayList<>();
        for (Item item : items) {
            int index = item.getItemStore().getId();
            Optional<ItemStore> itemStore = itemStoreRepository.findById(index);
            if (itemStore.isPresent())
                itemsList.add(itemStore.get());
        }
        return itemsList;
    }

    @Override
    public boolean compareItemNames(List<Item> items, int itemStoreId) {
        boolean value = false;
        for(Item item: items) {
            Optional<ItemStore> itemStore = itemStoreRepository.findById(itemStoreId);
            if (itemStore.isPresent()) {
                value = item.getItemStore().getItemName().equals(itemStore.get().getItemName());
            }
        }
        return value;
    }

    @Override
    public void deleteItemById(int id) {
        itemStoreRepository.deleteById(id);
    }
}
