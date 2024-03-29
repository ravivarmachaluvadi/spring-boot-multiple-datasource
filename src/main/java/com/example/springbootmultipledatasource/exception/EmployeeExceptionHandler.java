package com.example.springbootmultipledatasource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import javax.validation.ConstraintViolationException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class EmployeeExceptionHandler {


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity handleEmployeeNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(ConstraintViolationException constraintViolations) {
        List<String> details = new ArrayList<>();
        constraintViolations.getConstraintViolations().stream().forEach(constraintViolation ->  details.add(constraintViolation.getMessage()));
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
