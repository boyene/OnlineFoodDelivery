package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.CreateRestaurantRequest;
import com.zosh.Food.Delivery.App.Response.MessageResponse;
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

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {

    @Autowired
    private RestaurantServiceImp restaurantService;
    @Autowired
    private UserServiceImp userService;


    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurantRequest request,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.createRestaurant(request,user);
        return new ResponseEntity<>(restaurant,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest request,
            @RequestHeader("Authorization")String jwt
    ,@PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.updateRestaurant(id,request);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(

            @RequestHeader("Authorization")String jwt
            ,@PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        restaurantService.deleteRestaurant(id);
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessage("Restaurant deleted Successfully..");
        return new ResponseEntity<>(messageResponse,HttpStatus.OK);
    }
    @PutMapping ("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(

            @RequestHeader("Authorization")String jwt
            ,@PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
       Restaurant restaurant= restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }

    @GetMapping ("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(

            @RequestHeader("Authorization")String jwt
            ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant= restaurantService.getRestaurantByUserId(user.getId());

        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }
}
