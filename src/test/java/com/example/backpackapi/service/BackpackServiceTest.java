package com.example.backpackapi.service;


import com.example.backpackapi.model.BackpackData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BackpackServiceTest {

    @Test
    @DisplayName("When given distance has duplicate items then keep the one with more kilometers")
    void removeDuplicate() {
        //Given
        List<BackpackData> backpackDataList = new ArrayList<>();
        backpackDataList.add(createBackpack("gloves", 15, 1));
        backpackDataList.add(createBackpack("gloves", 50, 2));

        //When
        var response = BackpackService.removeDuplicates(backpackDataList);

        //Then
        Assertions.assertEquals(createBackpack("gloves", 50, 2), response.get(0));

    }

    private BackpackData createBackpack(String name, int kilometers, int quantity) {
        BackpackData backpackData = new BackpackData();
        backpackData.setName(name);
        backpackData.setKilometers(kilometers);
        backpackData.setQuantity(quantity);
        return backpackData;
    }
}
