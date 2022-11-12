package com.example.trelloapiwithspringboot.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:27 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class GenericNotFoundException extends RuntimeException{
    public GenericNotFoundException(String message) {
        super(message);
    }
}
