package br.com.banco.api.exception;

public class ContaNotFoundException extends RuntimeException {

    public ContaNotFoundException() {
        super("Conta não encontrada.");
    }

    public ContaNotFoundException(String message) {
        super(message);
    }

}
