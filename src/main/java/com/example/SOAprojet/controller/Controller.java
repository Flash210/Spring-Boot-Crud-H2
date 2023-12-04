package com.example.SOAprojet.controller;


import com.example.SOAprojet.ServiceFood;
import com.example.SOAprojet.model.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {



    @Autowired
      ServiceFood foodItemService;

    @PostMapping("/create")
    public String createFoodItem(@RequestBody FoodItem foodItem) {
         foodItemService.createFoodItem(foodItem);

         return "FoodItem created successfully";
    }



    @GetMapping("/all")
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/getFood{id}")
    public Optional<FoodItem> getFoodItemById(@PathVariable Long id) {
        return foodItemService.getFoodItemById(id);
    }



    @PutMapping("/{id}")
    public Optional<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem updatedFoodItem) {
        return foodItemService.updateFoodItem(id, updatedFoodItem);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
        return "FoodItem deleted successfully";
    }
}