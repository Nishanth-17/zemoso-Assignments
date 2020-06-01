package com.example.springsecuritylogin.Repository;

import com.example.springsecuritylogin.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
