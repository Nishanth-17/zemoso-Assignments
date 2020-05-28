package com.example.SpringApp.Entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "item")
public @Data @AllArgsConstructor @NoArgsConstructor class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "item_id")
    private int itemId;

    @Size(min=1, message = "Item Name is Required")
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;

    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}


