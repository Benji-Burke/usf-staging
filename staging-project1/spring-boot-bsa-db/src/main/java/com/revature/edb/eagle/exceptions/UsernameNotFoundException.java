package com.revature.edb.eagle.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(){
        super("No username exists! Try again.");
    }

    public UsernameNotFoundException(String message){
        super(message);
    }
}