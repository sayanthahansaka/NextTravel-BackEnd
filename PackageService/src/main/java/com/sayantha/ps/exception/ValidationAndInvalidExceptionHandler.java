package com.sayantha.ps.exception;

import com.sayantha.hs.exception.InvalidException;
import com.sayantha.ps.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationAndInvalidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseUtil> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ResponseUtil(400, errorMessage, null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<ResponseUtil> handleInvalidException(InvalidException ex) {
        return new ResponseEntity<>(new ResponseUtil(400, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
