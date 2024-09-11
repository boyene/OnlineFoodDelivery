package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.Dto.RestaurantDto;
import com.zosh.Food.Delivery.App.Request.CreateRestaurantRequest;
import com.zosh.Food.Delivery.App.model.Restaurant;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RestaurantService {


    Restaurant createRestaurant(CreateRestaurantRequest req, User user);


    public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantRequest updatedRestaurant)throws Exception;
    public void deleteRestaurant(Long restaurantId)throws Exception;
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> searchRestaurant(String keyword);
    public Restaurant findRestaurantById(Long id)throws Exception;
    public Restaurant getRestaurantByUserId(Long userId)throws Exception;
    public RestaurantDto addToFavorites(Long restaurantId,User user)throws Exception;
    public Restaurant updateRestaurantStatus(Long id)throws Exception;
}
