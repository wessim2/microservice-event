package com.example.ticketservice.services.impl;

import com.example.ticketservice.dto.TicketType.CreateTicketTypeRequest;
import com.example.ticketservice.dto.clients.EventResponse;
import com.example.ticketservice.entities.TicketType;
import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.mappers.TicketType.TicketTypeMapper;
import com.example.ticketservice.repositories.TicketTypeRepository;
import com.example.ticketservice.services.ITicketTypeService;
import com.example.ticketservice.services.clients.EventFeignClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketTypeService implements ITicketTypeService {
    private final TicketTypeRepository _ticketTypeRepository;
    private final EventFeignClient _eventFeignClient;
    @Override
    public TicketType createTicketType(CreateTicketTypeRequest request) {
        TicketType ticketType = TicketTypeMapper.mapToTicketType(request);
        // verify eventId
        ResponseEntity<EventResponse> event = _eventFeignClient.getEvent(ticketType.getEventId());

        return _ticketTypeRepository.save(ticketType);
    }

    @Override
    public List<TicketType> getTicketTypesByEvent() {
        return List.of();
    }

    @Override
    public TicketType getTicketTypeById(int id) {
        return null;
    }

    @Override
    public TicketType updateTicketType(Long ticketTypeID, TicketType ticketType) {
        return null;
    }

    @Override
    public void deleteTicketTypeById(int id) {

    }
}
