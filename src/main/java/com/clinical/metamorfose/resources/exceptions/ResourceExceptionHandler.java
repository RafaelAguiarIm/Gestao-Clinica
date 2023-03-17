package com.clinical.metamorfose.resources.exceptions;

import com.clinical.metamorfose.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

//@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
