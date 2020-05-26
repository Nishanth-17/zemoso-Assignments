package com.example.springsecuritylogin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public @Data @AllArgsConstructor @NoArgsConstructor class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    //@Unique(message="Email already registered!!!")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> items;

    @Column(name = "password")
    private String password;

    @Transient
    @Column(name="password_confirm")
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;


    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public User(int userId, String userName, String userEmail, String userMobile) {
        this.userId = userId;
        this.username = userName;
        this.email = userEmail;
        this.mobile = userMobile;
    }

    public void add(Item item){
        if(items==null){
            items=new ArrayList<>();
        }
        items.add(item);
    }

}
