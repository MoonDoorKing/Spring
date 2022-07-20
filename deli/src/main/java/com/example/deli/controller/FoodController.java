package com.example.deli.controller;

import com.example.deli.dto.FoodRequestDto;
import com.example.deli.dto.FoodResponseDto;
import com.example.deli.model.Food;
import com.example.deli.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void foodRegister(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> foodRequestDtoList) {
        foodService.additionalFood(foodRequestDtoList,restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getMenu(@PathVariable Long restaurantId) {
        return foodService.getMenu(restaurantId);
    }
}
