package com.abani.capstone.nutrients.NutrientsFoodApi.serviceimpl;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Food;
import com.abani.capstone.nutrients.NutrientsFoodApi.repository.FoodRepository;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> retrieveFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> getFood(Long foodId) {
        return foodRepository.findById(foodId);
    }

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    @Override
    public void updateFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public Food findByName(String name) {
        return foodRepository.findByName(name);
    }
}
