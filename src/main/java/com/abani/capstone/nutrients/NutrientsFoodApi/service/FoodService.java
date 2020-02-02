package com.abani.capstone.nutrients.NutrientsFoodApi.service;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    public List<Food> retrieveFoods();

    public Optional<Food> getFood(Long foodId);

    public void saveFood(Food food);

    public void deleteFood(Long foodId);

    public void updateFood(Food food);

    public Food findByName(String name);
}
