package com.example.eventservice.services;

import com.example.eventservice.entities.Event;

import java.util.List;

public interface IEventService {
    public Event addEvent(Event event);
    public List<Event> getAllEvents();
}
