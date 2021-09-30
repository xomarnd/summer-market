package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.services.CategoryService;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CategoryEntity not found, id: " + id));
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }
}
