package com.example.springsecuritylogin.Controller;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.Rating;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Service.ItemService;
import com.example.springsecuritylogin.Service.ItemStoreService;
import com.example.springsecuritylogin.Service.RatingService;
import com.example.springsecuritylogin.Service.UserService;
import com.example.springsecuritylogin.Validation.ItemValidator;
import com.example.springsecuritylogin.Validation.RatingValidator;
import com.example.springsecuritylogin.Validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemStoreService itemStoreService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ItemValidator itemValidator;

    @Autowired
    private RatingValidator ratingValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(userForm);
        model.addAttribute("successFlag",userForm.getUsername());

        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/update")
    public String showUpdateUserForm(Model model, Authentication authentication){
        model.addAttribute("user",userService.findByUsername(authentication.getName()));
        return "update-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, Authentication authentication, Model model) {
        userValidator.validateUpdate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update-form";
        }
            userService.updateUser(user);
            model.addAttribute("updateSuccessFlag", "success");
            return "user-info";
        }

    @GetMapping("/updatePassword")
    public String showFormForUpdatePassword(Model model,Authentication authentication) {
        model.addAttribute("user",userService.findByUsername(authentication.getName()));
        return "update-password";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute("user") User user, BindingResult bindingResult, Authentication authentication, Model model){
        userValidator.validateUpdatePassword(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update-password";
        }
        userService.saveUser(user);
        model.addAttribute("updatePasswordSuccessFlag","success");
        return "user-info";
    }

    @GetMapping("/showInfo")
    public String showInfo(Model model,Authentication authentication){
        model.addAttribute("user",userService.findByUsername(authentication.getName()));
        return "user-info";
    }

    @GetMapping("/list")
    public String list(Model model, Authentication authentication){
        //DOUBT
        List<ItemStore> itemStores=itemStoreService.getItemStoreByUser(userService.findByUsername(authentication.getName()).getId());
        List<Item> items=itemService.getItemsByUser(userService.findByUsername(authentication.getName()).getId());
        model.addAttribute("rate",new Rating());
        model.addAttribute("ratings",ratingService.getRatingListByItemStore(itemStores));
        model.addAttribute("itemStores",itemStores);
        model.addAttribute("quantity",itemService.getQuantityList(items));
        model.addAttribute("totalList",itemService.getTotalList(items));
        model.addAttribute("cartTotal",itemService.getCartTotal(items));
        model.addAttribute("items",items);
        return "list-item";
    }

    @GetMapping("/showItems")
    public String itemList(Model model){
        model.addAttribute("itemStores",itemStoreService.getItems());
        model.addAttribute("ratings",ratingService.getRatingListByItemStore(itemStoreService.getItems()));
        model.addAttribute("item",new Item());
        return "item-list";
    }

    @PostMapping("/save/{id}")
    public String saveItem(@ModelAttribute("item") Item item, BindingResult bindingResult, @PathVariable("id") int id, Authentication authentication, Model model){
        itemValidator.validate(item,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("quantityError","denied");
            return "item-list";
        }
        List<Item> items=itemService.getItemsByUser(userService.findByUsername(authentication.getName()).getId());
        if(itemStoreService.compareItemNames(items,id)){
                model.addAttribute("updateDenied", "success");
                return "item-list";
            }
        itemService.addItems(item,userService.findByUsername(authentication.getName()),id);
        return "redirect:/list";
    }

    @PostMapping("/rating/{id}")
    public String rateItem(@ModelAttribute("rate") Rating rating,BindingResult bindingResult, @PathVariable("id") int id, Authentication authentication,Model model){
        ratingValidator.validate(rating,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("ratingDenied","Denied");
           return "list-item";
        }
        int r=rating.getRating();
        rating = ratingService.getRatingByItemStore(itemStoreService.getItemById(id));
        ratingService.addRating(rating,itemStoreService.getItemById(id),r);
        model.addAttribute("ratingSaved","success");
        return "list-item";
    }

    @GetMapping("/showRatings")
    public String ratingList(Model model){
        model.addAttribute("itemStores",itemStoreService.getItems());
        model.addAttribute("ratings",ratingService.getRatingListByItemStore(itemStoreService.getItems()));
        return "rating-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") int id, Authentication authentication){
        itemService.deleteItemById(id,userService.findByUsername(authentication.getName()).getId());
        return "redirect:/list";
    }

}
