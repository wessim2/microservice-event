package com.example.eventservice.mapper.category;

import com.example.eventservice.dto.categoryDto.CategoryDto;
import com.example.eventservice.entities.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

}
