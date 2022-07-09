package com.example.spitaljpa1.errors;

public class UniqueFieldException extends RuntimeException{
    public UniqueFieldException() {}
    public UniqueFieldException(String message) { super(message);}
    public UniqueFieldException(String message, Throwable throwable) { super(message, throwable);}
}
