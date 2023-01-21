package com.cg.exception;

public class ContactNumberAlreadyExistsException extends RuntimeException {
	
    private String message;
    public ContactNumberAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public ContactNumberAlreadyExistsException() {
    }
}