package com.abani.capstone.nutrients.NutrientsFoodApi.serviceimpl;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.VersionTable;
import com.abani.capstone.nutrients.NutrientsFoodApi.repository.VersionTableRepository;
import com.abani.capstone.nutrients.NutrientsFoodApi.service.VersionTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionTableServiceImpl implements VersionTableService {

    @Autowired
    VersionTableRepository versionTableRepository;

    @Override
    public List<VersionTable> retrieveVersionTable() {
        return versionTableRepository.findAll();
    }

    @Override
    public Optional<VersionTable> getVersionTable(Long versionTableId) {
        return versionTableRepository.findById(versionTableId);
    }

    @Override
    public void saveVersionTable(VersionTable versionTable) {
        versionTableRepository.save(versionTable);
    }

    @Override
    public void deleteVersionTable(Long nutrientResponseId) {
        versionTableRepository.deleteById(nutrientResponseId);
    }

    @Override
    public void updateVersionTable(VersionTable versionTable) {
        versionTableRepository.save(versionTable);
    }
}
