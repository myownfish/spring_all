package com.luv2code.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Kitty", "Yu"));
        students.add(new Student("Chris", "Li"));
    }

    @RequestMapping("/students")
    public List<Student> getStudentList() {
        return students;
    }

    @RequestMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return students.get(studentId);
    }
    
    @ExceptionHandler
    public ResponseEntity<StudentErrorMessage> handleStudentNotFoundException(StudentNotFoundException e) {
        StudentErrorMessage msg = new StudentErrorMessage(123, e.getMessage(), System.currentTimeMillis());
        
        return new ResponseEntity<StudentErrorMessage>(msg, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ResponseEntity<StudentErrorMessage> handleException(Exception e) {
        StudentErrorMessage msg = new StudentErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        
        return new ResponseEntity<StudentErrorMessage>(msg, HttpStatus.BAD_REQUEST);
    }
}
