package net.morher.div.rest.error.advice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.morher.div.rest.error.validation.ValidationException;
import net.morher.div.rest.error.validation.Violation;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<Violation>> handleValidationException(ValidationException ve) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ve.getViolations());
    }
}
