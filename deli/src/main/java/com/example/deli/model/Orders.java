package com.example.deli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private int totalPrice;

    public Orders(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void update(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
