package com.example.deli.repository;

import com.example.deli.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    Optional<Restaurant> findById (Long restaurantId);
}
