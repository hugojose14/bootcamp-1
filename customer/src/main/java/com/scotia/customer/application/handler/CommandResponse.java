package com.scotia.customer.application.handler;

public class CommandResponse <T> {

    private T valor;

    public CommandResponse(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}
