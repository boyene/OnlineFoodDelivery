package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.Request.OrderRequest;
import com.zosh.Food.Delivery.App.model.Order;
import com.zosh.Food.Delivery.App.model.User;

import java.util.List;

public interface OrderService {


    public Order createOrder(OrderRequest order, User user) throws Exception;
    public Order updateOrder(Long orderId,String orderStatus)throws Exception;
    public void cancleOrder(Long orderId)throws Exception;
    public List<Order> getUsersOrder(Long userId)throws Exception;
    public List<Order> getRestaurantsOrder(Long restaurantId,String orderStatus)throws Exception;


    public Order findByOrderById(Long orderId)throws Exception;


}
