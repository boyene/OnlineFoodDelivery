package com.zosh.Food.Delivery.App;

import com.zosh.Food.Delivery.App.Dto.RestaurantDto;
import com.zosh.Food.Delivery.App.Request.CreateRestaurantRequest;
import com.zosh.Food.Delivery.App.Service.RestaurantService;
import com.zosh.Food.Delivery.App.model.Restaurant;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FoodDeliveryAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(FoodDeliveryAppApplication.class, args);
		System.out.println("hi..............");
	}




}
