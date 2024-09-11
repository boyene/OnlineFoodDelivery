package com.zosh.Food.Delivery.App.Request;

import com.zosh.Food.Delivery.App.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
