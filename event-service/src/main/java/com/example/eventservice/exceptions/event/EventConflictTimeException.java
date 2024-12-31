package com.example.eventservice.exceptions.event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EventConflictTimeException extends RuntimeException {

    public EventConflictTimeException(String message){
        super(message);
    }
}
