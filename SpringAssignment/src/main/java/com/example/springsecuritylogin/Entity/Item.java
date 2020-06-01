package com.example.springsecuritylogin.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "item")
public @Data @AllArgsConstructor @NoArgsConstructor class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemstore_id")
    private ItemStore itemStore;

    public Item(int id, int quantity, Float total, User user) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.user = user;
    }
    public Item(int id, int quantity, Float total) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
    }
}


