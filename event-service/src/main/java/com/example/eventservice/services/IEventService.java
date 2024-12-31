package com.example.eventservice.services;

import com.example.eventservice.dto.eventDto.EventDto;
import com.example.eventservice.entities.Event;

import java.util.List;

public interface IEventService {
    public Event addEvent(EventDto event);
    public List<Event> getAllEvents();
    public Event getEventByName(String name);
}
