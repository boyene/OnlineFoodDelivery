package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.OrderRequest;
import com.zosh.Food.Delivery.App.Service.OrderServiceImpl;
import com.zosh.Food.Delivery.App.Service.UserServiceImp;
import com.zosh.Food.Delivery.App.model.Order;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImp userServiceImp;





    @GetMapping("/orders/restaurant/{id}")
    public ResponseEntity<List<Order>>getOrderHistory(@PathVariable Long id,
            @RequestParam(required = false) String order_status,
            @RequestHeader ("Authorization")String jwt)throws Exception{
        User user=userServiceImp.findUserByJwtToken(jwt);
        List<Order>orders=orderService.getRestaurantsOrder(id,order_status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }



    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order>  updateOrderStatus(@PathVariable Long id,
                                                    @PathVariable String orderStatus,
                                                      @RequestHeader ("Authorization")String jwt)throws Exception{
        User user=userServiceImp.findUserByJwtToken(jwt);
        Order order=orderService.updateOrder(id,orderStatus);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
