package com.zosh.Food.Delivery.App.Response;

import com.zosh.Food.Delivery.App.model.USER_ROLE;
import com.zosh.Food.Delivery.App.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
