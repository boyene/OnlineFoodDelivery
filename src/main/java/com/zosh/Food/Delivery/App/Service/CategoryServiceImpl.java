package com.zosh.Food.Delivery.App.Service;

import com.zosh.Food.Delivery.App.Repository.CategoryRepository;
import com.zosh.Food.Delivery.App.model.Category;
import com.zosh.Food.Delivery.App.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private RestaurantServiceImp restaurantService;
    @Autowired
    private CategoryRepository categoryRepository;







    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurant=restaurantService.getRestaurantByUserId(userId);
        Category category=new Category();
        category.setName(name);
        category.setRestaurant(restaurant);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
        Restaurant restaurant=restaurantService.getRestaurantByUserId(id);
        return  categoryRepository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        Optional<Category>category=categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new Exception("category Not Found" );
        }
        return category.get();
    }
}
