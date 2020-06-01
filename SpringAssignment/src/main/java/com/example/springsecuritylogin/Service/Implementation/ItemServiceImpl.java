package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.ItemRepository;
import com.example.springsecuritylogin.Repository.ItemStoreRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemStoreRepository itemStoreRepository;
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Float> getTotalList(List<Item> items) {
        List<Float> totalList=new ArrayList<>();
        for(Item item: items){
            totalList.add(item.getTotal());
        }
        return totalList;
    }

    @Override
    public List<Integer> getQuantityList(List<Item> items) {
        List<Integer> quantityList=new ArrayList<>();
        for(Item item:items){
            quantityList.add(item.getQuantity());
        }
        return quantityList;
    }

    @Override
    public Float getCartTotal(List<Item> items) {
        float cartTotal=0;
        for(Item item:items){
            cartTotal+=item.getTotal();
        }
        return cartTotal;
    }

    @Override
    public List<Item> getItemsByUser(int id) {
           return userRepository.findById(id).get().getItems();
    }

    @Override
    public Item addItems(Item item, User user, int itemStoreId){
        item.setUser(user);
        Optional<ItemStore> itemStore=itemStoreRepository.findById(itemStoreId);
        if(itemStore.isPresent()) {
            item.setItemStore(itemStore.get());
        }
        int quantity=item.getQuantity();
        float price=item.getItemStore().getPrice();
        item.setTotal(quantity * price);
        return itemRepository.save(item);
    }

    @Override
    public void deleteItemById(int id,int userId) {
        Optional<ItemStore> itemStore=itemStoreRepository.findById(id);
        if(itemStore.isPresent()) {
            List<Item> items = itemStore.get().getItems();
            for(int i=0;i<items.size();i++) {
                if (items.get(i).getUser().getId() == userId) {
                    itemRepository.deleteById(items.get(i).getId());
                }
            }
        }
    }
}
