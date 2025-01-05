package com.example.organizerservice.exceptions;


import com.example.organizerservice.dto.ErrorResponseDto;
import com.example.organizerservice.exceptions.organizer.OrganizerFoundEmailException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                            WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
   /* @ExceptionHandler(EventConflictTimeException.class)
    public ResponseEntity<ErrorResponseDto> handleEventConflictException(EventConflictTimeException exception,
                                                                         WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                exception.getMessage()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.CONFLICT);
    }*/
    @ExceptionHandler(OrganizerFoundEmailException.class)
    public ResponseEntity<ErrorResponseDto> handleOrganizerEmailAlreadyExistsException(OrganizerFoundEmailException exception,
                                                                                 WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                exception.getMessage()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponseDto> handleOEventNotFoundException(FeignException exception,
                                                                                       WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
}
