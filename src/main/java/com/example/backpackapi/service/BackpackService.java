package com.example.backpackapi.service;

import com.example.backpackapi.model.Backpack;
import com.example.backpackapi.model.Item;
import com.example.backpackapi.model.BackpackData;
import com.example.backpackapi.model.ResponseBackpack;
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

    public ResponseBackpack getBackpack(int kilometers, String hikeDate) {
        Backpack backpack = new Backpack();
        ResponseBackpack responseBackpack = new ResponseBackpack();
        try {
            BackpackValidator.validateRequest(kilometers, hikeDate);
            var itemsByKilometersAndSeason = backPackRepository.getByKilometersLessThanEqualAndSeasonContaining(kilometers, calculateSeason(hikeDate));
            var itemsWithoutDuplicates = removeDuplicates(itemsByKilometersAndSeason);

            backpack.setItems(mapResponse(itemsWithoutDuplicates));
            responseBackpack.setBackpack(backpack);
            return responseBackpack;
        } catch (Exception e) {
            responseBackpack.setErrorMessage(e.getMessage());
            return responseBackpack;
        }
    }

    static String calculateSeason(String dateString) {
        LocalDate date = LocalDate.parse(dateString);

        Month month = date.getMonth();
        return switch (month) {
            case DECEMBER, JANUARY, FEBRUARY -> "Winter";
            case MARCH, APRIL, MAY -> "Spring";
            case JUNE, JULY, AUGUST -> "Summer";
            case SEPTEMBER, OCTOBER, NOVEMBER -> "Autumn";
        };
    }

    static List<BackpackData> removeDuplicates(List<BackpackData> backpackDataList) {
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

    private List<Item> mapResponse(List<BackpackData> list) {
        return list.stream()
                .map(this::mapToBackpack)
                .collect(Collectors.toList());
    }

    private Item mapToBackpack(BackpackData backpackData) {
        return new Item(backpackData.getName(), backpackData.getQuantity());
    }
}

