package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.model.IngredientCategory;
import com.zosh.Food.Delivery.App.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {

    public IngredientCategory createIngrediantCategory(String name,Long restaurantId)throws Exception;
    public IngredientCategory findIngredientCategoryById(Long id)throws Exception;
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id)throws Exception;
    public IngredientsItem createIngredientItem(Long restaurantId,String ingredientId,Long categoryId)throws Exception;
    public List<IngredientsItem> findRestaurantIngredients(Long restaurantId);
    public IngredientsItem updateStock(Long id)throws Exception;

}
