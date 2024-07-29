package com.project.crud.config.exceptions;

public class NoExisteLaCajaDeAhorroException extends RuntimeException{
    private String message;
    public NoExisteLaCajaDeAhorroException() {}
    public NoExisteLaCajaDeAhorroException(String msg) {
        super(msg);
        this.message = msg;
    }
}
