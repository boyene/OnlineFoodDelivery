package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.CreateFoodRequest;
import com.zosh.Food.Delivery.App.Response.MessageResponse;
import com.zosh.Food.Delivery.App.Service.*;
import com.zosh.Food.Delivery.App.model.Food;
import com.zosh.Food.Delivery.App.model.Restaurant;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodServiceImp foodService;

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private RestaurantServiceImp restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurant());
        Food food=foodService.createFood(req,req.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                           @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        foodService.deleteFood(id);
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessage("Food Delete Successfuly.");
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailability(@PathVariable Long id,
                                                      @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

       Food food=foodService.updateAvilibilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.OK);

    }


}
