package com.zosh.Food.Delivery.App.Request;

import com.zosh.Food.Delivery.App.model.Category;
import com.zosh.Food.Delivery.App.model.IngredientsItem;
import lombok.Data;

import java.util.List;
@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurant;
    private boolean vegetarin;
    private boolean seasional;
    private List<IngredientsItem> ingredientsItems;



}
