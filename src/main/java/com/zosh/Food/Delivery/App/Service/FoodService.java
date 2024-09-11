package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.Request.CreateFoodRequest;
import com.zosh.Food.Delivery.App.model.Category;
import com.zosh.Food.Delivery.App.model.Food;
import com.zosh.Food.Delivery.App.model.Restaurant;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurantId);
    public void deleteFood(Long foodId)throws Exception;
    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegitarain,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory);
    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId)throws Exception;
    public Food updateAvilibilityStatus(Long foodId) throws Exception;
}
