package com.samith.employeems.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeMSException extends RuntimeException {

    public EmployeeMSException() {
    }

    public EmployeeMSException(String message) {
        super(message);
    }

    public EmployeeMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
