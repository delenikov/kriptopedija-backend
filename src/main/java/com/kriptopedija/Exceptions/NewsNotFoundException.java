package com.kriptopedija.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NewsNotFoundException extends RuntimeException{

    public NewsNotFoundException(Long Id) {
        super(String.format("News with id: %s was not found", Id));
    }
}
