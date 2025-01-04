package com.example.ticketservice.services;

import com.example.ticketservice.dto.TicketType.CreateTicketTypeRequest;
import com.example.ticketservice.entities.TicketType;

import java.util.List;

public interface ITicketTypeService {
    public TicketType createTicketType(CreateTicketTypeRequest request);
    public List<TicketType> getTicketTypesByEvent();
    public TicketType getTicketTypeById(int id);
    public TicketType updateTicketType(Long ticketTypeID ,TicketType ticketType);
    public void deleteTicketTypeById(int id); // if there is no ticket associated to this type

}
