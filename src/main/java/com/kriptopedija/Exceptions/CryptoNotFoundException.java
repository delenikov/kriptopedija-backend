package com.kriptopedija.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CryptoNotFoundException extends RuntimeException{

    public CryptoNotFoundException(String name) {
        super(String.format("Crypto with name: %s was not found", name));
    }
}