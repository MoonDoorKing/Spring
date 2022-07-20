package com.example.deli.service;

import com.example.deli.dto.FoodRequestDto;
import com.example.deli.dto.FoodResponseDto;
import com.example.deli.model.Food;
import com.example.deli.repository.FoodRepsitory;
import com.example.deli.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepsitory foodRepsitory;
    private final RestaurantRepository restaurantRepository;

    //음식 등록
    @Transactional
    public void additionalFood(List<FoodRequestDto> foodRequestDto,Long restaurantId) {
        for (int i = 0; i < foodRequestDto.size(); i++) {
            
            Food food = new Food(foodRequestDto.get(i), restaurantRepository.findById(restaurantId).get());

            if(food.getPrice() < 100 || food.getPrice() > 1000000 || food.getPrice() % 100 != 0) {
                throw new IllegalArgumentException("금액오류");
            }
            if(foodRepsitory.existsByRestaurantIdAndName(restaurantId,food.getName())) {
                throw new IllegalArgumentException("음식 이름 오류");
            }

            foodRepsitory.save(food);
        }
    }

    public List<FoodResponseDto> getMenu(Long restaurantId) {
         List<Food> foods = foodRepsitory.findAllByRestaurantId(restaurantId);
         List<FoodResponseDto> foodResponseDto = new ArrayList<>();
         for(int i=0; i < foods.size(); i++)
         {
             foodResponseDto.add(new FoodResponseDto(foods.get(i).getId(),foods.get(i).getName(),foods.get(i).getPrice()));
         }
        return foodResponseDto;
    }
}
