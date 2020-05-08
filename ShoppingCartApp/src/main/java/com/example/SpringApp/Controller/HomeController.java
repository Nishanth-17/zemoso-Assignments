package com.example.SpringApp.Controller;

import com.example.SpringApp.Entity.Item;
import com.example.SpringApp.Entity.User;
import com.example.SpringApp.Service.ItemService;
import com.example.SpringApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    private int id;

    @GetMapping("/users/list")
    public String getUsers(Model model) {
        List<User> users= userService.getUsers();
        model.addAttribute("users", users);
        return "list-users";
    }
    
    @GetMapping("/users/cart/{id}")
    public String getItems(@PathVariable("id") int id, Model model){
        this.id=id;
        List<Item> items=itemService.getItemsByUser(id);
        model.addAttribute("item", items);
        return "list-items";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

    @GetMapping("/users/showFormForAdd")
    public String addUser(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/users/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
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
    public String saveItem(@Valid @ModelAttribute("item") Item item,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "item-form";
        }
        User user=userService.getUserById(id);
        itemService.addItems(item, user);
        return "redirect:/users/cart/"+id;
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable("id") int id){
        itemService.deleteItemById(id);
        return "redirect:/users/cart/"+this.id;
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
