package com.example.ticketservice.services.clients;

import com.example.ticketservice.dto.clients.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("event-service")
public interface EventFeignClient {
    @GetMapping(value="/api/events/{id}",consumes = "application/json")
    public ResponseEntity<EventResponse> getEvent(@PathVariable("id") Long id);
}
