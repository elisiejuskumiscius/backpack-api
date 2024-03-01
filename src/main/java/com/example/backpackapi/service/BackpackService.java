package com.example.backpackapi.service;

import com.example.backpackapi.model.Backpack;
import com.example.backpackapi.model.BackpackData;
import com.example.backpackapi.model.Response;
import com.example.backpackapi.repository.BackPackRepository;
import com.example.backpackapi.validator.BackpackValidator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BackpackService {

    @Resource
    private BackPackRepository backPackRepository;

    public Response getBackpack(int kilometers, String hikeDate) {
        BackpackValidator.validateRequest(kilometers, hikeDate);
        var season = calculateSeason(hikeDate);
        var itemsByKilometersAndSeason = backPackRepository.getByKilometersLessThanEqualAndSeasonContaining(kilometers, season);
        var itemsWithoutDuplicates = removeDuplicates(itemsByKilometersAndSeason);

        return new Response(mapResponse(itemsWithoutDuplicates));
    }

    private String calculateSeason(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        Month month = date.getMonth();
        return switch (month) {
            case DECEMBER, JANUARY, FEBRUARY -> "Winter";
            case MARCH, APRIL, MAY -> "Spring";
            case JUNE, JULY, AUGUST -> "Summer";
            case SEPTEMBER, OCTOBER, NOVEMBER -> "Autumn";
        };
    }


    private List<BackpackData> removeDuplicates(List<BackpackData> backpackDataList) {
        Map<String, List<BackpackData>> maxKilometersMap = new HashMap<>();

        for (BackpackData data : backpackDataList) {
            String name = data.getName();

            if (!maxKilometersMap.containsKey(name)) {
                List<BackpackData> dataList = new ArrayList<>();
                dataList.add(data);
                maxKilometersMap.put(name, dataList);
            } else {
                maxKilometersMap.get(name).add(data);
            }
        }

        List<BackpackData> resultList = new ArrayList<>();
        for (List<BackpackData> dataList : maxKilometersMap.values()) {
            dataList.stream()
                    .max(Comparator.comparingInt(BackpackData::getKilometers)).ifPresent(resultList::add);
        }

        return resultList;
    }

    private List<Backpack> mapResponse(List<BackpackData> list) {
        return list.stream()
                .map(this::mapToBackpack)
                .collect(Collectors.toList());
    }

    private Backpack mapToBackpack(BackpackData backpackData) {
        return new Backpack(backpackData.getName(), backpackData.getQuantity());
    }
}

