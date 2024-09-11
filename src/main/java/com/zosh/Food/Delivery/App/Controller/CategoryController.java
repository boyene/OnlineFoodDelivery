package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Service.CategoryService;
import com.zosh.Food.Delivery.App.Service.CategoryServiceImpl;
import com.zosh.Food.Delivery.App.Service.UserService;
import com.zosh.Food.Delivery.App.Service.UserServiceImp;
import com.zosh.Food.Delivery.App.model.Category;
import com.zosh.Food.Delivery.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private UserServiceImp userService;


    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category,
            @RequestHeader ("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Category createdCategory=categoryService.createCategory(category.getName(),user.getId());
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }


    @GetMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory(@RequestHeader ("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Category> createdCategory=categoryService.findCategoryByRestaurantId(user.getId());
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
}
