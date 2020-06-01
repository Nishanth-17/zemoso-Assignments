package com.example.springsecuritylogin;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.ItemStore;
import com.example.springsecuritylogin.Entity.Rating;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.ItemRepository;
import com.example.springsecuritylogin.Repository.ItemStoreRepository;
import com.example.springsecuritylogin.Repository.RatingRepository;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.ItemService;
import com.example.springsecuritylogin.Service.ItemStoreService;
import com.example.springsecuritylogin.Service.RatingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceTest {
    @Autowired
    private RatingService ratingService;

    @MockBean
    private RatingRepository ratingRepository;

    @Test
    public void addRatingTest(){
        ItemStore itemStore=new ItemStore(1,"Bottle",Float.valueOf(100),"Tupperware");
        Rating rating=new Rating(1,3,itemStore);
        itemStore.setRating(rating);
        when(ratingRepository.save(rating)).thenReturn(rating);
        assertNotEquals(6,ratingService.addRating(rating,itemStore,1).getRating());
        assertEquals(1,ratingService.addRating(rating,itemStore,1).getId());
    }
}
