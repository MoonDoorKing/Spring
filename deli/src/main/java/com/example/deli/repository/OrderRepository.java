package com.example.deli.repository;

import com.example.deli.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
