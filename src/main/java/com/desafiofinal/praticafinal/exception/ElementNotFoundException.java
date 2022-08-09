package com.desafiofinal.praticafinal.exception;

import lombok.Getter;

@Getter
public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String message){
        super();
    }
}
