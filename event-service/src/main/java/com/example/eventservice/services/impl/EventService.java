package com.example.eventservice.services.impl;

import com.example.eventservice.dto.eventDto.EventDto;
import com.example.eventservice.entities.Event;
import com.example.eventservice.exceptions.ResourceNotFoundException;
import com.example.eventservice.exceptions.event.EventConflictTimeException;
import com.example.eventservice.mapper.event.EventMapper;
import com.example.eventservice.repositories.EventRepository;
import com.example.eventservice.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final EventRepository _eventRepository;
    @Override
    public Event addEvent(EventDto eventDto) {
        Optional<Event> optionalEvent = _eventRepository.findByDateAndVenue(eventDto.getDate(),eventDto.getVenue());

        if(optionalEvent.isPresent()) {
            throw new EventConflictTimeException("There is an event at the same TIME and in the same VENUE");
        }

        Event event = EventMapper.mapToEvent(eventDto);

        return _eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return _eventRepository.findAll();
    }

    @Override
    public Event getEventByName(String name) {
        return _eventRepository.findByNameIgnoreCase(name).orElseThrow(
                ()-> new ResourceNotFoundException("Event","Name",name)
        );
    }

    @Override
    public Event getEventById(Long id) {
        return _eventRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Event","Id",id.toString())
        );
    }
}
