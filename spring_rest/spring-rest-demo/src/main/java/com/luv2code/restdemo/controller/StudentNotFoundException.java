package com.luv2code.restdemo.controller;

public class StudentNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 6991031006831619899L;

    public StudentNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public StudentNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
