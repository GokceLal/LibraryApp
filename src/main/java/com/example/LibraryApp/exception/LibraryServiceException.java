package com.example.LibraryApp.exception;

import lombok.Getter;

@Getter
public class LibraryServiceException extends RuntimeException {

    private final ErrorType errorType;

    public LibraryServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public LibraryServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
