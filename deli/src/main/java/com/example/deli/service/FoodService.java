package com.example.deli.service;

import com.example.deli.dto.FoodRequestDto;
import com.example.deli.model.Food;
import com.example.deli.repository.FoodRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepsitory foodRepsitory;

    @Autowired
    public FoodService(FoodRepsitory foodRepsitory) {
        this.foodRepsitory = foodRepsitory;
    }

    //음식 등록
    @Transactional
    public String additionalFood(List<FoodRequestDto> foodRequestDto,Long restaurantId) {
        for (int i = 0; i < foodRequestDto.size(); i++) {
            Food food = new Food(foodRequestDto.get(i), restaurantId);
            if(food.getPrice() < 100 || food.getPrice() > 1000000 || food.getPrice() % 100 != 0) {
                throw new IllegalArgumentException("금액오류");
            }
            if(foodRepsitory.existsByRestaurantIdAndName(restaurantId,food.getName())) {
                throw new IllegalArgumentException("음식 이름 오류");
            }
            foodRepsitory.save(food);
        }
        return "등록완료";
    }

    public List<Food> getMenu(Long restaurantId) {
        return foodRepsitory.findAllByRestaurantId(restaurantId);
    }
}
