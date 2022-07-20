package com.example.deli.dto;

import com.example.deli.model.OrderList;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderReqeustDto {
    private Long restaurantId;
    private List<OrderListRequestDto> foods;
}
