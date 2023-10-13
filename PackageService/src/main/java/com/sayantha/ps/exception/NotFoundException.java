package com.sayantha.ps.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String massage){
        super(massage);
    }
}
