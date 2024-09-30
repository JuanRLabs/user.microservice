package com.user.user.configuration.exceptionhandler;

import com.user.user.domain.exception.EmptyFieldUserException;
import com.user.user.domain.exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EmptyFieldUserException.class)
    public ResponseEntity<ExceptionResponse> handlerEmptyFieldUserException(EmptyFieldUserException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handler(IllegalArgumentException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handlerUserAlreadyExistException(UserAlreadyExistException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()));
    }


}
