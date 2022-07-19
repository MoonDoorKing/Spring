package com.example.deli.model;

import com.example.deli.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter @Setter
public class Restaurant {

    // ID 가 자동으로 생성 및 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;


    public Restaurant(RestaurantRequestDto restaurantRequestDto)
    {
        this.name = restaurantRequestDto.getName();
        this.minOrderPrice = restaurantRequestDto.getMinOrderPrice();
        this.deliveryFee = restaurantRequestDto.getDeliveryFee();
    }

    public Restaurant(String name,int minOrderPrice,int deliveryFee)
    {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}
