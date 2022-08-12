package com.desafiofinal.praticafinal.exception;

import lombok.Getter;

@Getter
public class ElementAlreadyExistsException extends RuntimeException{
    public ElementAlreadyExistsException(String message){
        super(message);
    }
}
