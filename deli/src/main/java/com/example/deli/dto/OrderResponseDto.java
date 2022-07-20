package com.example.deli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderResponseDto {

    private String restaurantName;

    private List<OrderListResponseDto> foods;

    private int deliveryFee;

    private int totalPrice;
}
