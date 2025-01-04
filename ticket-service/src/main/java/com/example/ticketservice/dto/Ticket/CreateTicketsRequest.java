package com.example.ticketservice.dto.Ticket;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateTicketsRequest {
    @NotEmpty
    private int count;
    @NotEmpty
    private String ticketType;
    @NotEmpty
    private Long eventId;
}
