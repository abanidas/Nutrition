package com.abani.capstone.nutrients.NutrientsFoodApi.repository;

import com.abani.capstone.nutrients.NutrientsFoodApi.entity.VersionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionTableRepository extends JpaRepository<VersionTable, Long> {
}
