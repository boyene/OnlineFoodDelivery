package com.zosh.Food.Delivery.App.Repository;

import com.zosh.Food.Delivery.App.model.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.beans.JavaBean;
import java.util.List;

@Repository
public interface IngredentItemRepository extends JpaRepository<IngredientsItem,Long> {

        List<IngredientsItem> findByRestaurantId(Long restaurantId);  // Correct naming convention

}


