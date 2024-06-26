package com.example.backpackapi.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Backpack extends RepresentationModel<Backpack> {
    List<Item> items;
}
