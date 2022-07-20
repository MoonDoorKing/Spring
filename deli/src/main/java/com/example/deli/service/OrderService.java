package com.example.deli.service;

import com.example.deli.dto.OrderListResponseDto;
import com.example.deli.dto.OrderReqeustDto;
import com.example.deli.dto.OrderResponseDto;
import com.example.deli.model.Food;
import com.example.deli.model.OrderList;
import com.example.deli.model.Orders;
import com.example.deli.model.Restaurant;
import com.example.deli.repository.FoodRepsitory;
import com.example.deli.repository.OrderListRepository;
import com.example.deli.repository.OrderRepository;
import com.example.deli.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepsitory foodRepsitory;
    private final RestaurantRepository restaurantRepository;
    private final OrderListRepository orderListRepository;


    // 주문 자체가 여러개가 아니기 때문에 List로 받지 않음. 주문 자체가 여러개면 List로 받아야함.
    @Transactional // 쓰는 족족 DB 에 반영 , 임시 DB 에 저장 후 중간에 오류가 없으면 DB 에 반영
    public OrderResponseDto createOrder(OrderReqeustDto orderReqeustDto) {
        Long restaurantId = orderReqeustDto.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Orders orders = new Orders(restaurant);
        Orders order = orderRepository.save(orders);
        int totalPrice = 0;

        // OrderList
        List<OrderList> orderLists = new ArrayList<>();

        for (int i = 0; i < orderReqeustDto.getFoods().size(); i++) {
            Long foodId = orderReqeustDto.getFoods().get(i).getId();
            Food food = foodRepsitory.findById(foodId).get();
            int quantity = orderReqeustDto.getFoods().get(i).getQuantity();
            int price = food.getPrice() * quantity;

            if(quantity>100 || quantity < 1)
                throw new IllegalArgumentException("허용 수량 초과");

            orderLists.add(new OrderList(order, food, quantity, price));

            totalPrice += price;
        }
        int minOrderPrice = restaurant.getMinOrderPrice();

        if (totalPrice < minOrderPrice) throw new IllegalArgumentException("최소 주문 금액 오류");

        List<OrderList> orderLists1 = orderListRepository.saveAll(orderLists);
        // orderList

        int deliveryFee = restaurant.getDeliveryFee();

        int totalTotalPrice = totalPrice + deliveryFee;

        order.update(totalTotalPrice);

        //List 는 add 로 담음.
        List<OrderListResponseDto> orderListResponseDto = new ArrayList<>();
        for(int i=0; i< orderLists1.size(); i++) {
           orderListResponseDto.add(new OrderListResponseDto(orderLists1.get(i).getFood().getName(),orderLists1.get(i).getQuantity(),orderLists1.get(i).getPrice()));
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto(restaurant.getName(), orderListResponseDto , restaurant.getDeliveryFee() , totalTotalPrice);

        return orderResponseDto;
    }

    public List<OrderResponseDto> showOrder() {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        List<Orders> orders = orderRepository.findAll();

        for(int i=0; i < orders.size(); i++ ) {
            List<OrderListResponseDto> orderListResponseDtoList = new ArrayList<>();
            List<OrderList> orderLists = orderListRepository.findAllByOrders(orders.get(i));

            for(int j=0; j < orderLists.size(); j++) {
                orderListResponseDtoList.add(new OrderListResponseDto(orderLists.get(j).getFood().getName(),orderLists.get(j).getQuantity(),orderLists.get(j).getPrice()));

            }
            orderResponseDtoList.add(new OrderResponseDto(orders.get(i).getRestaurant().getName(),orderListResponseDtoList,orders.get(i).getRestaurant().getDeliveryFee(),orders.get(i).getTotalPrice()));
        }

        return orderResponseDtoList;
    }

}
