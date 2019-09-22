package com.abani.capstone.nutrients.NutrientsFoodApi.serviceimpl;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.Nutrients;
import com.abani.capstone.nutrients.NutrientsFoodApi.repository.NutrientRepository;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutrientServiceImpl implements NutrientService {

    @Autowired
    private NutrientRepository nutrientRepository;

    @Override
    public List<Nutrients> retrieveNutrients() {
        return nutrientRepository.findAll();
    }

    @Override
    public Optional<Nutrients> getNutrient(Long employeeId) {
        return nutrientRepository.findById(employeeId);
    }

    @Override
    public void saveNutrient(Nutrients nutrient) {
        nutrientRepository.save(nutrient);
    }

    @Override
    public void deleteNutrient(Long nutrientId) {
        nutrientRepository.deleteById(nutrientId);
    }

    @Override
    public void updateNutrient(Nutrients nutrient) {
        nutrientRepository.save(nutrient);
    }

    @Override
    public Nutrients findByName(String name) {
        return nutrientRepository.findByName(name);
    }
}
