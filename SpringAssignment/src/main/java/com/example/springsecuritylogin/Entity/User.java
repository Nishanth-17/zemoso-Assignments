package com.example.springsecuritylogin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Transient;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "user")
public @Data @AllArgsConstructor @NoArgsConstructor class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    //@Unique(message="Email already registered!!!")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(name = "password")
    private String password;

    @Transient
    @Column(name="password_confirm")
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    public User(int userId, String userName, String userEmail, String userMobile) {
        this.id = userId;
        this.username = userName;
        this.email = userEmail;
        this.mobile = userMobile;
    }

    public User(int id, String username, String email, String mobile,  String password, String passwordConfirm) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
}
