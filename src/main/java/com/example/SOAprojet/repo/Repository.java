package com.example.SOAprojet.repo;

import com.example.SOAprojet.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<FoodItem, Long> {
    // You can add custom query methods here if needed
}
