package doo.gl.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import doo.gl.user.exception.EntityNotFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {
        logger.warn("There was an unexpected error", ex);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handle(EntityNotFoundException ex) {
        logger.warn("Could not find entity", ex);
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .build();
    }
    
}
