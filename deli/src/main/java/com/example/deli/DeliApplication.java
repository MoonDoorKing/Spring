package com.example.deli;

import com.example.deli.model.Restaurant;
import com.example.deli.repository.RestaurantRepository;
import com.example.deli.service.RestaurantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class DeliApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(RestaurantRepository restaurantRepository, RestaurantService restaurantService) {
        return (args) -> {
            restaurantRepository.save(new Restaurant("가게", 5000, 500));
            List<Restaurant> restaurantList = restaurantRepository.findAll();
            for(int i = 0; i < restaurantList.size(); i++)
            {
                Restaurant restaurant = restaurantList.get(i);
                System.out.println(restaurant.getId());
                System.out.println(restaurant.getName());
                System.out.println(restaurant.getMinOrderPrice());
                System.out.println(restaurant.getDeliveryFee());
            }
        };
    }
}
