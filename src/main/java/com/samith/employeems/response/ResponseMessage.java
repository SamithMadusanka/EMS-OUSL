package com.samith.employeems.response;


/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public enum ResponseMessage {

    SUCCESSFULLY_SENT("Successfully sent.");
    private String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
