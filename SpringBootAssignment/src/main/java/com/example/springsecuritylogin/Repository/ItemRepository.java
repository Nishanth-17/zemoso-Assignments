package com.example.springsecuritylogin.Repository;

import com.example.springsecuritylogin.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
