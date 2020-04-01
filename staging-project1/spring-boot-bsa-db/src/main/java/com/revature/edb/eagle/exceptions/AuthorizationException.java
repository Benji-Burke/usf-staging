package com.revature.edb.eagle.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("You are not authorized to do this!");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
