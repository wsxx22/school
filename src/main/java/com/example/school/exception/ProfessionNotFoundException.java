package com.example.school.exception;

public class ProfessionNotFoundException extends RuntimeException{

    public ProfessionNotFoundException(String ex) {
        super(ex);
    }
}
