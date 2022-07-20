package com.example.deli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderListResponseDto {
    private String name;
    private int quantity;
    private int price;
}
