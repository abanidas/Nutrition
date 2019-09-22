package com.abani.capstone.nutrients.NutrientsFoodApi.service;


import com.abani.capstone.nutrients.NutrientsFoodApi.entity.VersionTable;

import java.util.List;
import java.util.Optional;

public interface VersionTableService {

    public List<VersionTable> retrieveVersionTable();

    public Optional<VersionTable> getVersionTable(Long versionTableId);

    public void saveVersionTable(VersionTable versionTable);

    public void deleteVersionTable(Long versionTableId);

    public void updateVersionTable(VersionTable versionTable);

}
