package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.Repository.IngredentCategoryRepository;
import com.zosh.Food.Delivery.App.Repository.IngredentItemRepository;
import com.zosh.Food.Delivery.App.model.IngredientCategory;
import com.zosh.Food.Delivery.App.model.IngredientsItem;
import com.zosh.Food.Delivery.App.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientsService{


    @Autowired
    private IngredentItemRepository ingredentItemRepository;

    @Autowired
    private IngredentCategoryRepository ingredentCategoryRepository;

    @Autowired
    private RestaurantServiceImp restaurantServiceImp;







    @Override
    public IngredientCategory createIngrediantCategory(String name, Long restaurantId) throws Exception {

        Restaurant restaurant=restaurantServiceImp.findRestaurantById(restaurantId);
        IngredientCategory category=new IngredientCategory();
        category.setRestaurant(restaurant);
        category.setName(name);



        return ingredentCategoryRepository.save(category);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> opt=ingredentCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("ingredient category not found");
        }


        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantServiceImp.findRestaurantById(id);
        return ingredentCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {

        Restaurant restaurant=restaurantServiceImp.findRestaurantById(restaurantId);
        IngredientCategory category=findIngredientCategoryById(categoryId);

        IngredientsItem item =new IngredientsItem();
        item.setName(ingredientName);
        item.setRestaurant(restaurant);
        item.setCategory(category);
        IngredientsItem ingredient=ingredentItemRepository.save(item);
        category.getIngredients().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngredientsItem> findRestaurantIngredients(Long restaurantId) {
        return ingredentItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {

        Optional<IngredientsItem> optional=ingredentItemRepository.findById(id);
        if(optional.isEmpty()){
            throw new Exception("Ingredient Not Found ");
        }
        IngredientsItem ingredientsItem=optional.get();
        ingredientsItem.setInStock(!ingredientsItem.isInStock());
        return ingredentItemRepository.save(ingredientsItem);
    }
}
