package com.example.deli.repository;

import com.example.deli.model.OrderList;
import com.example.deli.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    List<OrderList> findAllByOrders(Orders orders);
}
