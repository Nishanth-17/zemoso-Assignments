package com.example.springsecuritylogin.Controller;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Service.ItemService;
import com.example.springsecuritylogin.Service.UserService;
import com.example.springsecuritylogin.Validation.ItemValidator;
import com.example.springsecuritylogin.Validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ItemValidator itemValidator;

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

    @GetMapping({"/","/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/updateForm")
    public String showUpdateUserForm(Model model, Authentication authentication){
        String username=authentication.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("user",user);
        return "update-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, Authentication authentication, Model model){
        userValidator.validateUpdate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update-form";
        }
        String username=authentication.getName();
        User newUser=userService.findByUsername(username);
        String password=newUser.getPasswordConfirm();
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPassword(password);
        user.setPasswordConfirm(password);
        if(user.getMobile().equals(newUser.getMobile())){
            model.addAttribute("notUpdated","false");
        }
        else {
            userService.saveUser(user);
            model.addAttribute("updateSuccessFlag", "success");
        }
        return "user-info";
    }
    @GetMapping("/updatePassword")
    public String showFormForUpdatePassword(Model model,Authentication authentication)
    {
        String username=authentication.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("user",user);
        return "update-password";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute("user") User user, BindingResult bindingResult, Authentication authentication, Model model){
        userValidator.validateUpdatePassword(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "update-password";
        }
        String username=authentication.getName();
        User newUser=userService.findByUsername(username);
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setMobile(newUser.getMobile());
        userService.saveUser(user);
        model.addAttribute("updatePasswordSuccessFlag","success");
        return "user-info";
    }

    @GetMapping("/showInfo")
    public String showInfo(Model model,Authentication authentication){
        String username=authentication.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("user",user);
        return "user-info";
    }

    @GetMapping("/list")
    public String list(Model model, Authentication authentication){
        String username=authentication.getName();
        User user=userService.findByUsername(username);
        List<Item> items=itemService.getItemsByUser(user.getUserId());
        model.addAttribute("item",items);
        return "list-item";
    }

    @GetMapping("/showFormForAdd")
    public String itemForm(Model model){
        Item item=new Item();
        model.addAttribute("item",item);
        return "item-form";
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Item item,BindingResult bindingResult, Authentication authentication){
        itemValidator.validate(item,bindingResult);
        if (bindingResult.hasErrors()) {
            return "item-form";
        }
        String username=authentication.getName();
        User user=userService.findByUsername(username);
        itemService.addItems(item,user);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") int id){
        itemService.deleteItemById(id);
        return "redirect:/list";
    }
}
