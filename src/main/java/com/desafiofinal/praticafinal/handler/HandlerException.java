package com.desafiofinal.praticafinal.handler;

import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.exception.ElementeAlreadyExistsException;
import com.desafiofinal.praticafinal.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException extends Throwable{

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionDetails> exceptionHandler(ElementNotFoundException ex){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(HttpStatus.NOT_FOUND.name())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ElementeAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> exceptionHandler(ElementeAlreadyExistsException ex){
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .status(HttpStatus.CONFLICT.value())
                        .message(HttpStatus.CONFLICT.name())
                        .build(), HttpStatus.CONFLICT
        );
    }
}
