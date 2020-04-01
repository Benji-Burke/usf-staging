package com.revature.edb.eagle.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(){
        super("Bad Request");

    }

    public BadRequestException(String message){
        super(message);
    }

}
