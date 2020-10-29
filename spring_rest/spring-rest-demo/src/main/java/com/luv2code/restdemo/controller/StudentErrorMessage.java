package com.luv2code.restdemo.controller;

public class StudentErrorMessage {
    
    private int statusCode;
    private String errorMsg;
    private long Timestamp;
    
    public StudentErrorMessage(int statusCode, String errorMsg, long timestamp) {
        super();
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
        Timestamp = timestamp;
    }
    public StudentErrorMessage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public long getTimestamp() {
        return Timestamp;
    }
    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }
    
    

}
