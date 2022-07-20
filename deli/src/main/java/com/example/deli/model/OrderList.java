package com.example.deli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Orders orders;

    @ManyToOne
    @JoinColumn
    private Food food;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    public OrderList(Orders orders, Food food, int quantity, int price) {
        this.orders = orders;
        this.food = food;
        this.quantity = quantity;
        this.price = price;
    }
}
