package com.example.SpringApp.Controller;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Service.Implementation.ItemServiceImpl;
import com.example.SpringApp.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemServiceImpl cartService;

    @Autowired
    private UserServiceImpl userService;

    private int Userid;

    @GetMapping("/users/list")
    public String listUsers(Model model) {
        List<User> usersList= userService.getUsers();
        model.addAttribute("users",usersList);
        return "list-users";
    }

    @GetMapping("/users/cart")
    public String listItems(@RequestParam("UserID") int theId, Model model){
        Userid=theId;
        List<Item> itemsList=cartService.getItemsByUser(theId);
        model.addAttribute("item",itemsList);
        return "list-items";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("UserID") int theId){
        userService.deleteUser(theId);
        return "redirect:/users/list";
    }

    @GetMapping("/users/showFormForAdd")
    public String addUser(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "user-form";
    }

    @GetMapping("/users/update")
    public String updateUser(@RequestParam("UserID") int theId, Model model){
        User theUser=userService.getUserById(theId);
        model.addAttribute("user",theUser);
        return "user-form";
    }

    @PostMapping("/users/save")
    public String saveUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user-form";
        }
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/items/showFormForAdd")
    public String addItem(Model model){
        Item item =new Item();
        model.addAttribute("item", item);
        return "item-form";
    }

    @PostMapping("/items/save")
    public String saveItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "item-form";
        }
        User user=userService.getUserById(Userid);
        cartService.addItems(item,user);
        return "redirect:/users/cart?UserID="+Userid;
    }

    @GetMapping("/items/delete")
    public String deleteItem(@RequestParam("ItemID") int theId){
        cartService.deleteItemById(theId);
        return "redirect:/users/cart?UserID="+Userid;
    }

    /*
    @GetMapping("/items/{id}")
    public ResponseEntity<List<Cart>> listItems(@PathVariable int id) {
        List<Cart> itemsList=cartService.getItemsByUser(id);
        return new ResponseEntity<>(itemsList,HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<Cart> saveItems(@RequestBody Cart cart){
        Cart theCart=cartService.addItems(cart);
        return new ResponseEntity<>(theCart,HttpStatus.OK);
    }
    @PutMapping("/items")
    public ResponseEntity<Cart> updateUser(@RequestBody Cart cart){
        Cart theCart=cartService.updateCart(cart);
        return new ResponseEntity<>(theCart,HttpStatus.OK);
    }

    @DeleteMapping("/items/{theId}")
    public String deleteItem(@PathVariable int theId){
        cartService.deleteItemById(theId);
        return "Item with Id "+theId+" is deleted.";
    }

*/

}
