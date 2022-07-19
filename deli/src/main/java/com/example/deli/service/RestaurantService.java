package com.example.deli.service;

import com.example.deli.dto.RestaurantRequestDto;
import com.example.deli.model.Food;
import com.example.deli.model.Restaurant;
import com.example.deli.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        if (restaurant.getMinOrderPrice() < 1000 || restaurant.getMinOrderPrice() > 100000 || restaurant.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("금액 오류");
        }
        if (restaurant.getDeliveryFee() > 10000 || restaurant.getDeliveryFee() < 0 || restaurant.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("배달비 오류");
        }
        restaurantRepository.save(restaurant);
        return restaurant;

    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
