package com.example.eventservice.dto.categoryDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDto {
    @NotEmpty(message = "Name must be filled")
    private String name;
}
