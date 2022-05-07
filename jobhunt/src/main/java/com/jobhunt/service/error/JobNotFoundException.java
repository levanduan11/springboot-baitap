package com.jobhunt.service.error;

public class JobNotFoundException extends Exception{

    public JobNotFoundException(String message) {
        super(message);
    }
}
