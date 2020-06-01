package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.Rating;
import com.example.springsecuritylogin.Repository.RatingRepository;
import com.example.springsecuritylogin.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Integer> getRatingListByItemStore(List<ItemStore> itemStores) {
        List<Integer> ratings=new ArrayList<>();
        for(ItemStore itemStore: itemStores){
            ratings.add(getRatingByItemStore(itemStore).getRating());
        }
        return ratings;
    }

    @Override
    public Rating addRating(Rating rating,ItemStore itemStore,int r){
        if(rating.getRating()==0) {
            rating.setRating(r);
            itemStore.setRating(rating);
        }
        else {
            int ratingPrev=itemStore.getRating().getRating();
            int ratingNew=r;
            if(ratingNew%2!=0)
                ratingNew+=1;
            int rate=(ratingPrev+ratingNew)/2;
            rating.setRating(rate);
            itemStore.setRating(rating);
        }
        rating.setItemStore(itemStore);
        return ratingRepository.save(rating);
    }
    @Override
    public Rating getRatingByItemStore(ItemStore itemStore){
        return itemStore.getRating();
    }
}
