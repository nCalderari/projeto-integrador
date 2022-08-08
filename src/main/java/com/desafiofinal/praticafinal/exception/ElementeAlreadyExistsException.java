package com.desafiofinal.praticafinal.exception;

import lombok.Getter;

@Getter
public class ElementeAlreadyExistsException extends RuntimeException{
    public ElementeAlreadyExistsException(String message){
        super();
    }
}
