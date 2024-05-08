package com.example.backpackapi.controller;

import com.example.backpackapi.model.Backpack;
import com.example.backpackapi.service.BackpackService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackpackController {

    @Resource
    private BackpackService backPackService;

    @GetMapping("/backpack")
    public Backpack getBackpack(@RequestParam int kilometers,
                                @RequestParam String hikeDate) {
        return backPackService.getBackpack(kilometers, hikeDate);
    }

}
