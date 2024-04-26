package com.pinheiro.email.exceptions;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String msg){
        super(msg);
    }
}
