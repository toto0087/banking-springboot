package com.project.crud.config.exceptions;

public class NoExisteLaDireccionException extends RuntimeException{
    private String message;
    public NoExisteLaDireccionException() {}
    public NoExisteLaDireccionException(String msg) {
        super(msg);
        this.message = msg;
    }
}
