package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Service.UserService;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;
@GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization")String jwt) throws Exception {
    User user=userService.findUserByJwtToken(jwt);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
