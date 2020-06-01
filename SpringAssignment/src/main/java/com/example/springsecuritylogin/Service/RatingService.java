package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.Rating;

import java.util.List;

public interface RatingService {
    List<Integer> getRatingListByItemStore(List<ItemStore> itemStores);
    Rating addRating(Rating rating, ItemStore itemStore,int r);
    Rating getRatingByItemStore(ItemStore itemStore);
}
