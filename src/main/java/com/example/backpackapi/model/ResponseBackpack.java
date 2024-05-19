package com.example.backpackapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseBackpack extends RepresentationModel<Backpack> {
    private Backpack backpack;
    private String errorMessage;
}
