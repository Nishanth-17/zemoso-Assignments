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
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "item_store")
public @Data @AllArgsConstructor @NoArgsConstructor class ItemStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="item_name")
    private String itemName;

    @Column(name="price")
    private float price;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "itemStore",cascade = CascadeType.REMOVE)
    private List<Item> items;

    @OneToOne(mappedBy = "itemStore",cascade = CascadeType.ALL)
    private Rating rating;

    public ItemStore(int id, String itemName, float price, String company) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.company = company;
    }
}
