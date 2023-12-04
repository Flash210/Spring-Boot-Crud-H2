package com.example.SOAprojet;


import com.example.SOAprojet.model.FoodItem;
import com.example.SOAprojet.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceFood {

    private final Repository foodItemRepository;

    @Autowired
    public ServiceFood(Repository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public Optional<FoodItem> updateFoodItem(Long id, FoodItem updatedFoodItem) {
        return foodItemRepository.findById(id)
                .map(existingFoodItem -> {
                    existingFoodItem.setName(updatedFoodItem.getName());
                    existingFoodItem.setDescription(updatedFoodItem.getDescription());
                    existingFoodItem.setPrice(updatedFoodItem.getPrice());
                    existingFoodItem.setImageUrl(updatedFoodItem.getImageUrl());
                    return foodItemRepository.save(existingFoodItem);
                });
    }

    public boolean deleteFoodItem(Long id) {
        return foodItemRepository.findById(id)
                .map(foodItem -> {
                    foodItemRepository.delete(foodItem);
                    return true;
                })
                .orElse(false);
    }
}