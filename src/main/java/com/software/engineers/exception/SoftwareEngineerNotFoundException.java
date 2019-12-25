package com.software.engineers.exception;

public class SoftwareEngineerNotFoundException extends RuntimeException {
    public SoftwareEngineerNotFoundException(String message){
        super(String.format("%s not found",message));
    }
}
