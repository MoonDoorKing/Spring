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
    //외래키는 기본키랑 연결이 된다.
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Food(FoodRequestDto foodRequestDto,Restaurant restaurant) {
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
        this.restaurant = restaurant;
    }
}
