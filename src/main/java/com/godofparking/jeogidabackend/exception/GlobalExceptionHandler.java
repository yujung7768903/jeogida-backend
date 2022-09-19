package com.godofparking.jeogidabackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationError(MethodArgumentNotValidException e) {
        StringBuilder builder = new StringBuilder();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();

        for (FieldError error : errors) {
            builder.append(error.getField() + " : " + error.getDefaultMessage() + "\n");
        }

        return ResponseEntity.status(400).body(builder.toString());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMessageNotReadableError(HttpMessageNotReadableException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> DuplicateError(DuplicateException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
