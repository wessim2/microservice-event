package com.example.organizerservice.services.clients;

import com.example.organizerservice.dto.event.EventResponse;

import com.example.organizerservice.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EventFallback implements EventFeignClient {

    @Override
    public EventResponse getEvent(Long id) {
        try {
            throw new ResourceNotFoundException("event","id",id.toString());
        } catch (Exception ex) {
            return new EventResponse();
        }
    }
}

