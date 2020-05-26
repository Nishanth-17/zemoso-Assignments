package com.example.springsecuritylogin.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
public @Data @AllArgsConstructor @NoArgsConstructor class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "users_user_id")
    private User user;

    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}


