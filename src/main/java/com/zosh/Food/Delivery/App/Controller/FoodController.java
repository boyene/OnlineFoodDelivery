package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.CreateFoodRequest;
import com.zosh.Food.Delivery.App.Service.*;
import com.zosh.Food.Delivery.App.model.Food;
import com.zosh.Food.Delivery.App.model.Restaurant;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodServiceImp foodService;

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private RestaurantServiceImp restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        List<Food> food=foodService.searchFood(name);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean vagetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg,
            @RequestParam (required = false) String food_category,
            @RequestParam Long restaurantId,
            @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.getRestaurantFood(restaurantId,vagetarian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }
}
