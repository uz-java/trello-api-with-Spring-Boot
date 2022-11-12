package com.example.trelloapiwithspringboot.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:28 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
