package com.revature.edb.eagle.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("No resource found with provided criteria!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
