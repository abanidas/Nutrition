package com.abani.capstone.nutrients.NutrientsFoodApi.service;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Nutrients;

import java.util.List;
import java.util.Optional;

public interface NutrientService {

    public List<Nutrients> retrieveNutrients();

    public Optional<Nutrients> getNutrient(Long nutrientId);

    public void saveNutrient(Nutrients nutrient);

    public void deleteNutrient(Long nutrientId);

    public void updateNutrient(Nutrients nutrient);

    public  Nutrients findByName(String name);
}
