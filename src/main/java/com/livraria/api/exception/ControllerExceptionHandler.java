package com.livraria.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> handleRuntimeException(RuntimeException e, HttpServletRequest request){
        int status = 400;
        String error = "Erro de negócio";
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                status,
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(standardError);
    }
}
