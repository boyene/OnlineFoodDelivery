package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.OrderRequest;
import com.zosh.Food.Delivery.App.Service.OrderService;
import com.zosh.Food.Delivery.App.Service.OrderServiceImpl;
import com.zosh.Food.Delivery.App.Service.UserServiceImp;
import com.zosh.Food.Delivery.App.model.CartItem;
import com.zosh.Food.Delivery.App.model.Order;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

       @Autowired
        private OrderServiceImpl orderService;

       @Autowired
        private UserServiceImp userServiceImp;


       @PostMapping("/order")
        public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                             @RequestHeader ("Authorization")String jwt)throws Exception{
           User user=userServiceImp.findUserByJwtToken(jwt);
           Order order=orderService.createOrder(req,user);
           return new ResponseEntity<>(order, HttpStatus.OK);
       }


    @GetMapping("/orders/user")
    public ResponseEntity<List<Order>>getOrderHistory(
                                                      @RequestHeader ("Authorization")String jwt)throws Exception{
        User user=userServiceImp.findUserByJwtToken(jwt);
        List<Order>orders=orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }



}
