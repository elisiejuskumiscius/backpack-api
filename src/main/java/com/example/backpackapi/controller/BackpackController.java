package com.example.backpackapi.controller;

import com.example.backpackapi.model.Backpack;
import com.example.backpackapi.model.BaseResponse;
import com.example.backpackapi.model.ResponseBackpack;
import com.example.backpackapi.service.BackpackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backpack")
@Tag(name = "Backpack Management System")
public class BackpackController {

    @Resource
    private BackpackService backPackService;

    @GetMapping()
    @Operation(summary = "Get a backpack for the given kilometers and hike date",
            description = "Provide kilometers and hike date to get the appropriate items for backpack")
    public ResponseBackpack getBackpack(@Parameter(description = "Value should be between 1 and 100") @RequestParam int kilometers,
                                    @Parameter(description = "Date format yyyy-MM-dd", example = "2024-05-19") @RequestParam String hikeDate) {
        ResponseBackpack backpack = backPackService.getBackpack(kilometers, hikeDate);
        backpack.add(WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BackpackController.class).getBackpack(kilometers, hikeDate))
                .withSelfRel());
        return backpack;
    }

}
