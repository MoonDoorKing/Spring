package com.example.deli.controller;

import com.example.deli.dto.RestaurantRequestDto;
import com.example.deli.model.Restaurant;
import com.example.deli.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    //음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant restaurantRegister(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantService.createRestaurant(restaurantRequestDto);

        return restaurant;
    }

    //음식점 전체 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }
}
