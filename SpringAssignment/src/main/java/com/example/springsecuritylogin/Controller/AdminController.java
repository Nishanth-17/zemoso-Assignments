package com.example.springsecuritylogin.Controller;

import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.Rating;
import com.example.springsecuritylogin.Service.ItemService;
import com.example.springsecuritylogin.Service.ItemStoreService;
import com.example.springsecuritylogin.Service.RatingService;
import com.example.springsecuritylogin.Service.UserService;
import com.example.springsecuritylogin.Validation.ItemStoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemStoreService itemStoreService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ItemStoreValidator itemStoreValidator;

    @GetMapping("/new")
    public String createItem(Model model){
        model.addAttribute("itemStore",new ItemStore());
        return "create-item";
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute("itemStore") ItemStore itemStore, BindingResult bindingResult){
        itemStoreValidator.validate(itemStore,bindingResult);
        if(bindingResult.hasErrors()){
            return "create-item";
        }
        itemStoreService.saveItem(itemStore);
        ratingService.addRating(new Rating(),itemStore,0);
        return "redirect:/welcome";
    }

    @GetMapping("/showItems")
    public String itemList(Model model){
        model.addAttribute("itemStores",itemStoreService.getItems());
        return "item-list-admin";
    }

    @GetMapping("/showUsers")
    public String usersList(Model model){
        model.addAttribute("users",userService.getUsers());
        return "user-list-admin";
    }

    @GetMapping("/showRatings")
    public String ratingList(Model model){
        model.addAttribute("itemStores",itemStoreService.getItems());
        model.addAttribute("ratings",ratingService.getRatingListByItemStore(itemStoreService.getItems()));
        return "rating-list-admin";
    }

    @GetMapping("/cart/{id}")
    public String showItemsByUserId(@PathVariable("id") int id, Model model){
        model.addAttribute("itemStores",itemStoreService.getItemStoreByUser(id));
        model.addAttribute("username",userService.getUserById(id).getUsername());
        model.addAttribute("quantity",itemService.getQuantityList(itemService.getItemsByUser(id)));
        model.addAttribute("totalList",itemService.getTotalList(itemService.getItemsByUser(id)));
        model.addAttribute("cartTotal",itemService.getCartTotal(itemService.getItemsByUser(id)));
        model.addAttribute("items",itemService.getItemsByUser(id));
        return "cart-user-admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteItem(@PathVariable("id") int id){
        itemStoreService.deleteItemById(id);
        return "redirect:/admin/showItems";
    }

}
