package com.example.ganczar.CaloriesTracker.controller;

import com.example.ganczar.CaloriesTracker.model.Food;
import com.example.ganczar.CaloriesTracker.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @PostMapping("/foods")
    public Food createFood(@RequestBody Food food) {
        Food savedFood = foodRepository.save(food);
        return savedFood;
    }

    @GetMapping("/foods")
    public List<Food> retrieveAllFoods() {
        return foodRepository.findAll();
    }

    @PutMapping("/foods/{id}")
    public Food updateFood(@PathVariable int id, @RequestBody Food food) {
        food.setId(id);
        return foodRepository.save(food);
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable int id, @RequestBody Food food) {
        food.setId(id);
        foodRepository.delete(food);
        return ResponseEntity.ok().build();
    }
}
