package com.example.backpackapi.controller;

import com.example.backpackapi.model.Backpack;
import com.example.backpackapi.service.BackpackService;
import jakarta.annotation.Resource;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
        Backpack backpack = backPackService.getBackpack(kilometers, hikeDate);
        backpack.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BackpackController.class).getBackpack(kilometers, hikeDate))
                .withSelfRel());
        return backpack;
    }

}
