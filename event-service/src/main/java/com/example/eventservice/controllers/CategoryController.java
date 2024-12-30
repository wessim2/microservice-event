package com.example.eventservice.controllers;


import com.example.eventservice.entities.Category;
import com.example.eventservice.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService _categoryService;

    public CategoryController(ICategoryService categoryService) {
        _categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCategory(@RequestBody Category request) {
        Category category = _categoryService.addCategory(request);
        if(category != null) {
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("This Category already exists",HttpStatus.CONFLICT);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllCategories() {
        List<Category> categories = _categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
