package com.example.backpackapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BackpackData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private int kilometers;
    private String season;
}
