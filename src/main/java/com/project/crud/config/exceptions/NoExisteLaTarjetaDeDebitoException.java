package com.project.crud.config.exceptions;

public class NoExisteLaTarjetaDeDebitoException extends RuntimeException {
    private String message;
    public NoExisteLaTarjetaDeDebitoException() {}
    public NoExisteLaTarjetaDeDebitoException(String msg) {
        super(msg);
        this.message = msg;
    }
}
