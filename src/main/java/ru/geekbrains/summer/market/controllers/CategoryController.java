package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.CategoryEntity;
import ru.geekbrains.summer.market.services.CategoryService;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryEntity findById(@PathVariable Long id) {
        CategoryEntity c = categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoryEntity not found, id: " + id));
        return c;
    }
}
//    public Category findById(@PathVariable Long id) {
//        Category c = categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found, id: " + id));
//        return c;
//    }

