package com.example.deli.controller;

import com.example.deli.dto.OrderReqeustDto;
import com.example.deli.dto.OrderResponseDto;
import com.example.deli.repository.OrderRepository;
import com.example.deli.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/order/request")
    public OrderResponseDto createOrder(@RequestBody OrderReqeustDto orderReqeustDto) {
        return orderService.createOrder(orderReqeustDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> showOrder() {
        return orderService.showOrder();
    }
}
