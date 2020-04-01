package com.revature.edb.eagle.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(){
        super("User doesn't exist");

    }

    public AuthenticationException(String message){
        super(message);
    }

}
