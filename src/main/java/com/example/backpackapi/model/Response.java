package com.example.backpackapi.model;

import java.util.List;

public record Response(
        List<Backpack> backpack
) {
}