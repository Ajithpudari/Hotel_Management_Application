package com.hotel.management.advice;

import com.hotel.management.Exception.EmptyInputException;
import com.hotel.management.Exception.EntityExistsException;
import com.hotel.management.Exception.EntityNotExistsException;
import com.hotel.management.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends RuntimeException {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Error Code = " + emptyInputException.getErrorCode()
                + ", Error Message = " + emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<String>("Error Code = " + notFoundException.getErrorCode()
                + ", Error Message = " + notFoundException.getErrorMessage(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> entityExistsException(com.hotel.management.Exception.EntityExistsException entityExistsException) {
        return new ResponseEntity<String>("Error Code = " + entityExistsException.getErrorCode()
                + ", Error Message = " + entityExistsException.getMessage(), HttpStatus.BAD_REQUEST);

}
    @ExceptionHandler(EntityNotExistsException.class)
    public ResponseEntity<String> entityNotExistsException(com.hotel.management.Exception.EntityNotExistsException entityNotExistsException) {
        return new ResponseEntity<String>("Error Code = " + entityNotExistsException.getErrorCode()
                + ", Error Message = " + entityNotExistsException.getMessage(), HttpStatus.BAD_REQUEST);
}}