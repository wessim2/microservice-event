package com.example.organizerservice.services.clients;

import com.example.organizerservice.dto.event.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "event-service",fallback = EventFallback.class)
public interface EventFeignClient {
    @GetMapping("/api/events/{id}")
    public EventResponse getEvent(@PathVariable Long id);
}
