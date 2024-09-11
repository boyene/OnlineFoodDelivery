package com.zosh.Food.Delivery.App.Controller;

import com.zosh.Food.Delivery.App.Request.IngredientCategoryRequest;
import com.zosh.Food.Delivery.App.Request.IngredientItemRequest;
import com.zosh.Food.Delivery.App.Service.IngredientServiceImpl;
import com.zosh.Food.Delivery.App.Service.IngredientsService;
import com.zosh.Food.Delivery.App.model.IngredientCategory;
import com.zosh.Food.Delivery.App.model.IngredientsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")

public class IngredientController {


    @Autowired
    private IngredientServiceImpl ingredientsService;

        @PostMapping("/category")
        public ResponseEntity<IngredientCategory> createIngredientCategory(
                @RequestBody IngredientCategoryRequest req
                ) throws Exception {
            IngredientCategory item=ingredientsService.createIngrediantCategory(req.getName(),req.getRestaurantId());
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        }

        @PostMapping()
        public ResponseEntity<IngredientsItem> createIngredientItem(
                @RequestBody IngredientItemRequest req
        ) throws Exception {
            IngredientsItem item=ingredientsService.createIngredientItem(req.getRestaurantId(),req.getName(),req.getCategoryId());
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        }


        @PutMapping("/{id}/stock")
        public ResponseEntity<IngredientsItem> updateIngredientStock(
                @PathVariable Long id
        ) throws Exception {
            IngredientsItem item=ingredientsService.updateStock(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }

        @GetMapping("/restaurant/{id}")
        public ResponseEntity<List<IngredientsItem>> getRestaurantIngredient(
                @PathVariable Long id
        )  {
           List<IngredientsItem>  items= ingredientsService.findRestaurantIngredients(id);
            return new ResponseEntity<>(items, HttpStatus.OK);
        }

        @GetMapping("/restaurant/{id}/category")
        public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(
                @PathVariable Long id
        ) throws Exception {
            List<IngredientCategory>  items= ingredientsService.findIngredientCategoryByRestaurantId(id);
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
}