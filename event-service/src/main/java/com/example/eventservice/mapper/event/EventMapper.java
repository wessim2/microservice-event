package com.example.eventservice.mapper.event;

import com.example.eventservice.dto.eventDto.EventDto;
import com.example.eventservice.entities.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setCategory(eventDto.getCategory());
        event.setDescription(eventDto.getDescription());
        event.setName(eventDto.getName());
        event.setVenue(eventDto.getVenue());
        event.setDate(eventDto.getDate());
        return event;
    }
}
