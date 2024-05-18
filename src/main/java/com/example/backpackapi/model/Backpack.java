package com.example.backpackapi.model;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class Backpack extends RepresentationModel<Backpack> {

    List<Item> items;
}
