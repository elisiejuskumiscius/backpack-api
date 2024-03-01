package com.example.backpackapi.controller;

import com.example.backpackapi.model.Response;
import com.example.backpackapi.service.BackpackService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BackpackController {

    @Resource
    private BackpackService backPackService;

    @GetMapping("/backpack")
    public Response getBackpack(@RequestParam  int kilometers,
                                @RequestParam   LocalDateTime hikeDate) {

        return backPackService.getBackpack(kilometers, hikeDate);
    }

}
