package com.example.ganczar.CaloriesTracker.repository;

import com.example.ganczar.CaloriesTracker.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface FoodRepository extends JpaRepository <Food, Integer> {

    List<Book> findByName(String name);
}
