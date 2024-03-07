package com.movie.expert.controllers;

import com.movie.expert.models.exceptions.PlatformError;
import com.movie.expert.models.exceptions.PlatformException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PlatformException.class)
    public ResponseEntity<PlatformError> handleCustomException(PlatformException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PlatformError(ex.getErrorCode(), ex.getErrorMsg()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlatformError> handleException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PlatformError(500, "Internal Server Error"));
    }
}
