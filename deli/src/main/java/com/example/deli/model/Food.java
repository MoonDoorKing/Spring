package com.example.deli.model;

import com.example.deli.dto.FoodRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @JsonIgnore
    @Column(nullable = false)
    private Long restaurantId;

    public Food(FoodRequestDto foodRequestDto,Long restaurantId) {
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();;
        this.restaurantId = restaurantId;
    }
}
