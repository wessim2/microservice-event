package com.example.eventservice.dto.eventDto;


import com.example.eventservice.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {
    @NotEmpty(message = "Name must be filled")
    private String name;
    @NotEmpty(message = "Description must be filled")
    private String description;
    @NotEmpty(message = "You must choose a date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
    @NotEmpty(message = "Select a venue")
    private String venue;
    @NotEmpty(message = "Select Category")
    Category category;
}
