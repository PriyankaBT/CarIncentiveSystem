package com.cg.exception;

public class DealerIdNotFoundException extends RuntimeException{

	private String message;
    public DealerIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public DealerIdNotFoundException() {
    }
}

