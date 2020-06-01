package com.example.springsecuritylogin.Repository;

import com.example.springsecuritylogin.Entity.ItemStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemStoreRepository extends JpaRepository<ItemStore, Integer> {
}
