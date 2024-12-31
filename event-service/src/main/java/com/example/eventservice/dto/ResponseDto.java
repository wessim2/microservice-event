package com.example.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    public String statusCode;
    public String statusMessage;
}
