package com.example.ticketservice.dto.TicketType;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateTicketTypeRequest {
    private Long eventId;         // Associated event ID
    private String typeName;      // e.g., VIP, Standard, General
    private BigDecimal price;     // Price for this ticket type
    private int capacity;
}
