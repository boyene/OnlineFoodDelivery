package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Dto.RestaurantDto;
import com.zosh.Food.Delivery.App.Request.CreateRestaurantRequest;
import com.zosh.Food.Delivery.App.Service.RestaurantService;
import com.zosh.Food.Delivery.App.Service.RestaurantServiceImp;
import com.zosh.Food.Delivery.App.Service.UserService;
import com.zosh.Food.Delivery.App.Service.UserServiceImp;
import com.zosh.Food.Delivery.App.model.Restaurant;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantServiceImp restaurantService;
    @Autowired
    private UserServiceImp userService;


    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization")String jwt
    ,@RequestParam String keyword) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(
            @RequestHeader("Authorization")String jwt
            ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @RequestHeader("Authorization")String jwt,@PathVariable Long id
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
       Restaurant restaurant=restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(
            @RequestHeader("Authorization")String jwt,@PathVariable Long id
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        RestaurantDto restaurant=restaurantService.addToFavorites(id, user);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
