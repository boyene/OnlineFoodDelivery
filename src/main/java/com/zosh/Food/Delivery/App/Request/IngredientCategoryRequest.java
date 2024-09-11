package com.zosh.Food.Delivery.App.Request;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
public class IngredientCategoryRequest {
    private String name;
    private Long restaurantId;

}
