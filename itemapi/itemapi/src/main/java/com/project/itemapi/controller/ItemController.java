package com.project.itemapi.controller;

import com.project.itemapi.model.Item;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    // Add new item
    @PostMapping
    public Item addItem(@Valid @RequestBody Item item) {
        items.add(item);
        return item;
    }

    // Get item by ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
