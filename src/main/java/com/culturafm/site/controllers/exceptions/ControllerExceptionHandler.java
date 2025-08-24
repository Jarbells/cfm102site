// src/main/java/com/culturafm/site/controllers/exceptions/ControllerExceptionHandler.java

package com.culturafm.site.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.culturafm.site.services.exceptions.ResourceConflictException;
import com.culturafm.site.services.exceptions.ResourceNotFoundException; // IMPORTAR

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<StandardError> resourceConflict(ResourceConflictException e, HttpServletRequest request) {
        String error = "Resource conflict";
        HttpStatus status = HttpStatus.CONFLICT; // 409
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    
    // NOVO MÉTODO PARA TRATAR ERRO 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}