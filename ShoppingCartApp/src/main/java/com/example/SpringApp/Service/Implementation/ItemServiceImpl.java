package com.example.SpringApp.Service.Implementation;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Repository.ItemRepository;
import com.example.SpringApp.Repository.UserRepository;
import com.example.SpringApp.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> getItemsByUser(int id) {
        List<Item> items=userRepository.findById(id).get().getItems();
        return items;
    }

    @Override
    public Item addItems(Item item, User user){
        /*User user=userRepository.findById(cart.getUser().getUserId()).orElse(null);
        if(user==null) {
            user = new User();
        }
        user.setUserName(cart.getUser().getUserName());
        */
        item.setUser(user);
        Item newItem = itemRepository.save(item);
        user.add(newItem);
        return newItem;
    }
    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }
}
