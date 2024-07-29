package com.project.crud.config.exceptions;

public class NoExisteLaPersonaException extends RuntimeException {
    private String message;
    public NoExisteLaPersonaException() {}
    public NoExisteLaPersonaException(String msg) {
        super(msg);
        this.message = msg;
    }
}
