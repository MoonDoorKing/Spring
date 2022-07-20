package com.example.deli.repository;

import com.example.deli.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepsitory extends JpaRepository<Food,Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByRestaurantIdAndName(Long restaurantId, String name);
}
