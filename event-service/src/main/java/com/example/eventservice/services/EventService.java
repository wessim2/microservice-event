package com.example.eventservice.services;

import com.example.eventservice.entities.Event;
import com.example.eventservice.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final EventRepository _eventRepository;
    @Override
    public Event addEvent(Event event) {
        Event existingEvent = _eventRepository.findByDateAndVenue(event.getDate(),event.getVenue());

        if(existingEvent != null) {
            return null;
        }
        return _eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return _eventRepository.findAll();
    }
}
