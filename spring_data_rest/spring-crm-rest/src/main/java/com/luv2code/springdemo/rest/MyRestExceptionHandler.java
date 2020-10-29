package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> customerNotFound(CustomerNotFoundException exp) {
        
        ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND.value(), exp.getMessage());
//        msg.setMessage(exp.getMessage());
//        msg.setStatusCode(HttpStatus.NOT_FOUND.value());
        
        return new ResponseEntity<ErrorMessage>(msg, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> badRequest(Exception exp) {
        
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), exp.getMessage());
//        msg.setMessage();
//        msg.setStatusCode();
        
        return new ResponseEntity<ErrorMessage>(msg, HttpStatus.BAD_REQUEST);
    }
}
