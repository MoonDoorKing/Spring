package com.example.deli.dto;

import lombok.Getter;

@Getter
public class FoodRequestDto {
    private String name;
    private int price;

    public FoodRequestDto(String name, int price)
    {
        this.name = name;
        this.price =price;
    }
}
