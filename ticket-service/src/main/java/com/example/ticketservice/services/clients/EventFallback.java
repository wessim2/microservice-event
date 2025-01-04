package com.example.ticketservice.services.clients;

import com.example.ticketservice.dto.clients.EventResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EventFallback implements EventFeignClient {
    @Override
    public ResponseEntity<EventResponse> getEvent(Long id) {
        return null;
    }
}

