package com.module.security.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.module.security.dto.ErrorMessage;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception) {
        // responseApiDto.setCodeName(HttpStatus.CREATED.series().name());
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.series().name(), HttpStatus.NOT_FOUND,
                exception.getMessage(), exception.hashCode());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
