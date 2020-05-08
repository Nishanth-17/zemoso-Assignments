package com.example.SpringApp.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.assertj.core.internal.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public @Data @AllArgsConstructor @NoArgsConstructor class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    @Size(min=1, message = "User Name is Required")
    @Column(name = "user_name")
    private String userName;

    @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",message="Enter a Valid Email Address")
    @Column(name = "user_email",unique = true)
    //@Unique(message="Email already registered!!!")
    private String userEmail;


    @Pattern(regexp="[0-9]{10}",message="Enter a valid Mobile Number of 10 digits")
    @Column(name="user_mobile")
    private String userMobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> items;

    public User(int userId, String userName, String userEmail, String userMobile) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
    }

    public void add(Item item){
        if(items==null){
            items=new ArrayList<>();
        }
        items.add(item);
    }
}
