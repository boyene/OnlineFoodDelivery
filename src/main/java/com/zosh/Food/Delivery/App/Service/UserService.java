package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.model.User;

public interface UserService {
    public User findUserByJwtToken(String jwt) throws Exception;
    public  User findUserByEmail(String email)throws Exception;
}
