package com.module.security.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.module.security.dto.ErrorMessage;
import com.module.security.dto.ResponseApiDto;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseApiDto responseApiDto;

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseApiDto> userNotFoundException(UserNotFoundException exception) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage(), exception.hashCode());

        responseApiDto = new ResponseApiDto();
        responseApiDto.setCodeResponse(HttpStatus.NOT_FOUND.value());
        responseApiDto.setCodeName(HttpStatus.NOT_FOUND.series().name());
        responseApiDto.setData(message.getMessage());

        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        return new ResponseEntity<ResponseApiDto>(responseApiDto, HttpStatus.OK);
    }

    /*
     * public ResponseEntity<ErrorMessage>
     * userNotFoundException(UserNotFoundException exception) {
     * ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
     * exception.getMessage(), exception.hashCode());
     * return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
     * }
     */
}
