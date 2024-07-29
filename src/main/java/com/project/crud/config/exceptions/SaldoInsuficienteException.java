package com.project.crud.config.exceptions;

public class SaldoInsuficienteException extends RuntimeException{
    private String message;
    public SaldoInsuficienteException() {}
    public SaldoInsuficienteException(String msg) {
        super(msg);
        this.message = msg;
    }
}
