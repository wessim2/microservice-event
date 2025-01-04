package com.example.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    public String statusCode;
    public String statusMessage;
}
