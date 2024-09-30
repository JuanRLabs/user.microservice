package com.user.user.domain.exception;

public class EmptyFieldUserException extends RuntimeException {
    public EmptyFieldUserException(String message) {
        super(message);
    }
}
