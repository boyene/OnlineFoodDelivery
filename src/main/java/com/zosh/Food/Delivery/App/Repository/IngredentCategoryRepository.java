package com.zosh.Food.Delivery.App.Repository;

import com.zosh.Food.Delivery.App.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredentCategoryRepository extends JpaRepository<IngredientCategory,Long> {


    List<IngredientCategory> findByRestaurantId(Long id);
}
