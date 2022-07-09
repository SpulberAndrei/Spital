package com.example.spitaljpa1.errors;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice

public class RestExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage(ex.getMessage());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException() {
        ErrorResponse response = new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED);
        response.setMessage("Requested method is not supported");
        return buildResponseEntity(response);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage("Invalid value for a field or its missing");
        return buildResponseEntity(response);
    }

    @ExceptionHandler(UniqueFieldException.class)
    public ResponseEntity<Object> handleUniqueEmailException(UniqueFieldException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage(ex.getMessage());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage("Make sure that you respect the data type");
        return buildResponseEntity(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("Id not found");
        return buildResponseEntity(response);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException() {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("Id not found");
        return buildResponseEntity(response);
    }
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<Object> handleNullPointerException() {
//        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
//        response.setMessage("One of the fields is missing");
//        return buildResponseEntity(response);
//    }
//@ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleIllegalStateException(Exception ex) {
//        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
//        response.setMessage("Something went wrong ! Please try to introduce all data correctly");
//        return buildResponseEntity(response);
//    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }


}
