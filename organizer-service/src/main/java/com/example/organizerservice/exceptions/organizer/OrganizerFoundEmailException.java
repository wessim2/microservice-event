package com.example.organizerservice.exceptions.organizer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class OrganizerFoundEmailException extends RuntimeException {
    public OrganizerFoundEmailException(String message){super(message);}
}
