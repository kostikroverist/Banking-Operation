package com.intelliarts.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class BankRestExceptionHandler {

    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<BankErrorResponce> handleException(Exception exception, WebRequest request){
        BankErrorResponce  bankErrorResponce = new BankErrorResponce(new Date(),exception.getMessage(),request.getDescription(false));
        exception.printStackTrace();
        return  new ResponseEntity<>(bankErrorResponce, HttpStatus.BAD_REQUEST);
    }
}
