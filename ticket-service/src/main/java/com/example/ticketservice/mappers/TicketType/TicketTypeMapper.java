package com.example.ticketservice.mappers.TicketType;

import com.example.ticketservice.dto.TicketType.CreateTicketTypeRequest;
import com.example.ticketservice.entities.TicketType;

public class TicketTypeMapper {
    public static TicketType mapToTicketType(CreateTicketTypeRequest dto)
    {
        TicketType ticketType = new TicketType();
        ticketType.setTypeName(dto.getTypeName());
        ticketType.setPrice(dto.getPrice());
        ticketType.setCapacity(dto.getCapacity());
        ticketType.setEventId(dto.getEventId());
        return ticketType;
    }
}
