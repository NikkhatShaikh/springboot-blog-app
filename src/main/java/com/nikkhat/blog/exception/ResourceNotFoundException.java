package com.nikkhat.blog.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource Not Found On server !!! ");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}