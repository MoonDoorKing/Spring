package com.example.deli.controller;

import com.example.deli.dto.FoodRequestDto;
import com.example.deli.model.Food;
import com.example.deli.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService)
    {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public String foodRegister(@PathVariable("restaurantId") Long restaurantId, @RequestBody List<FoodRequestDto> foodRequestDto) {
        return foodService.additionalFood(foodRequestDto,restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getMenu(@PathVariable("restaurantId") Long restaurantId) {
        return foodService.getMenu(restaurantId);
    }
}
