package com.example.backpackapi.repository;

import com.example.backpackapi.model.BackpackData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BackPackRepository extends CrudRepository<BackpackData, Integer> {

    List<BackpackData> getByKilometersLessThanEqualAndSeasonContaining(int kilometers, String season);
}
