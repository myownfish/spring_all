package com.luv2code.restdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<StudentErrorMessage> handleStudentNotFoundException(StudentNotFoundException e) {
        StudentErrorMessage msg = new StudentErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        
        return new ResponseEntity<StudentErrorMessage>(msg, HttpStatus.NOT_FOUND);
    }
}
