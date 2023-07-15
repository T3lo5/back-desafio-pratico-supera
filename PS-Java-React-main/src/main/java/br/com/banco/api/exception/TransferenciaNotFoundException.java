package br.com.banco.api.exception;

public class TransferenciaNotFoundException extends RuntimeException {
    public TransferenciaNotFoundException(String message) {
        super(message);
    }
}
