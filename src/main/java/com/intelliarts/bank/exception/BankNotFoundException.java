package com.intelliarts.bank.exception;

public class BankNotFoundException extends RuntimeException{


    public BankNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankNotFoundException(String message) {
        super(message);
    }

    public BankNotFoundException(Throwable cause) {
        super(cause);
    }
}
