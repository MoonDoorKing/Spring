package com.example.deli.repository;

import com.example.deli.model.Food;
import com.example.deli.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepsitory extends JpaRepository<Food,Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByRestaurantIdAndName(Long restaurantId, String name);
}
