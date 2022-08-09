package com.desafiofinal.praticafinal.exception;

import lombok.Getter;

@Getter
public class ElementNotFoundException extends RuntimeException{

    ElementNotFoundException(String message){
        super();
    }
}
