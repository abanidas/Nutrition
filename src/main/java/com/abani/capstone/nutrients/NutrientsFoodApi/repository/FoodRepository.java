package com.abani.capstone.nutrients.NutrientsFoodApi.repository;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByName(String name);
}
