package com.project.crud.config.exceptions;

public class NoExisteLaCuentaException extends RuntimeException {
    private String message;
    public NoExisteLaCuentaException() {}
    public NoExisteLaCuentaException(String msg) {
        super(msg);
        this.message = msg;
    }
}
