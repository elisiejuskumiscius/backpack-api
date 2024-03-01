package com.example.backpackapi.repository;

import com.example.backpackapi.model.BackpackData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BackPackRepository extends JpaRepository<BackpackData, Integer> {

    List<BackpackData> getByKilometersLessThanEqualAndSeasonContaining(int kilometers, String season);
}
